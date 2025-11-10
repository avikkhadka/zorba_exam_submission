package flightbookingsystem.controller;

import flightbookingsystem.dao.PassengerDAO;
import flightbookingsystem.entity.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    private PassengerDAO passengerDAO;

    // ---------------- Passenger Registration ----------------
    @GetMapping("register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("passenger", new Passenger());
        return "passenger_register";
    }

    @PostMapping("savePassengerInfo")
    public String savePassenger(@ModelAttribute("passenger") Passenger passenger) {
        System.out.println("Passenger received: " + passenger);
        passengerDAO.savePassenger(passenger);
        return "redirect:/passenger/login?registered=true";

    }

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

            session.setAttribute("loggedInPassenger", existingPassenger); // store passenger in session
            return "redirect:/flight/list";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "passenger_login";
        }
    }


    @GetMapping("list")
    public String listPassengers(Model model) {
        model.addAttribute("passengers", passengerDAO.getAllPassengers());
        return "passenger_list"; // JSP page to display all passengers
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Passenger passenger = passengerDAO.getPassengerById(id);
        model.addAttribute("passenger", passenger);
        return "passenger_edit"; // JSP page for editing
    }

    @PostMapping("/updatePassengerInfo")
    public String updatePassenger(@ModelAttribute("passenger") Passenger passenger) {
        passengerDAO.updatePassenger(passenger);
        return "redirect:/passenger/list";
    }

    @PostMapping("/deletePassenger/{id}")
    public String deletePassenger(@PathVariable("id") Long id) {
        System.out.println("delete method called");
        passengerDAO.deletePassenger(id);
        return "redirect:/passenger/list";
    }


}
