package flightbookingsystem.controller;

import flightbookingsystem.dao.PassengerDAO;
import flightbookingsystem.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private PassengerDAO passengerDAO;

    // ---------------- Passenger Registration Form ----------------
    @GetMapping("register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("passenger", new Passenger());
        return "passenger_register";
    }


    @PostMapping("savePassengerInfo")
    @ResponseBody
    public ResponseEntity<Map<String, String>> savePassenger(@RequestBody Passenger passenger) {
        Map<String, String> response = new HashMap<>();


        if (passenger.getPassengerName() == null || passenger.getPassengerEmail() == null ||
                passenger.getPassengerMobile() == null || passenger.getPassengerAddress() == null ||
                passenger.getPassengerUsername() == null || passenger.getPassengerPassword() == null) {

            response.put("message", "All fields are required!");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            passengerDAO.savePassenger(passenger);
            response.put("message", "Passenger registered successfully!");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (DataIntegrityViolationException ex) {
            response.put("message", "Duplicate username");
            return new ResponseEntity<>(response, HttpStatus.CONFLICT);
        } catch (Exception ex) {
            response.put("message", "Server error: " + ex.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ---------------- Login ----------------
    @GetMapping("login")
    public String showLoginPage(Model model) {
        model.addAttribute("passenger", new Passenger());
        return "passenger_login";
    }

    @PostMapping("login")
    public String loginPassenger(@ModelAttribute("passenger") Passenger passenger,
                                 Model model, HttpSession session) {
        Passenger existingPassenger = passengerDAO.getPassengerByUsername(passenger.getPassengerUsername());

        if (existingPassenger != null && existingPassenger.getPassengerPassword().equals(passenger.getPassengerPassword())) {
            session.setAttribute("loggedInPassenger", existingPassenger);
            return "redirect:/flight/list";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "passenger_login";
        }
    }

    // ---------------- Passenger List ----------------
    @GetMapping("list")
    public String listPassengers(Model model) {
        model.addAttribute("passengers", passengerDAO.getAllPassengers());
        return "passenger_list";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Passenger passenger = passengerDAO.getPassengerById(id);
        model.addAttribute("passenger", passenger);
        return "passenger_edit";
    }

    @PostMapping("/updatePassengerInfo")
    public String updatePassenger(@ModelAttribute("passenger") Passenger passenger) {
        passengerDAO.updatePassenger(passenger);
        return "redirect:/passenger/list";
    }

    @PostMapping("/deletePassenger/{id}")
    public String deletePassenger(@PathVariable("id") Long id) {
        passengerDAO.deletePassenger(id);
        return "redirect:/passenger/list";
    }
}
