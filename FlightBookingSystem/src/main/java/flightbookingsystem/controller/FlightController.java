package flightbookingsystem.controller;

import flightbookingsystem.dao.FlightDAO;
import flightbookingsystem.entity.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/flight")
public class FlightController {

    @Autowired
    private FlightDAO flightDAO;

    @GetMapping("registration")
    public String showFlightForm(Model model, HttpSession session) {
        if (session.getAttribute("loggedInPassenger") == null) {
            return "redirect:/passenger/login";
        }
        model.addAttribute("flight", new Flight());
        return "flight_registration";
    }

    @PostMapping("saveFlight")
    public String saveFlight(@ModelAttribute("flight") Flight flight, HttpSession session) {
        if (session.getAttribute("loggedInPassenger") == null) {
            return "redirect:/passenger/login";
        }
        flightDAO.saveFlight(flight);
        return "redirect:/flight/list";
    }

    @GetMapping("list")
    public String listFlights(Model model, HttpSession session) {
        if (session.getAttribute("loggedInPassenger") == null) {
            return "redirect:/passenger/login";
        }
        model.addAttribute("flights", flightDAO.getAllFlights());
        return "flight_list";
    }

    @GetMapping("edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model, HttpSession session) {
        if (session.getAttribute("loggedInPassenger") == null) {
            return "redirect:/passenger/login";
        }
        Flight flight = flightDAO.getFlightById(id);
        model.addAttribute("flight", flight);
        return "flight_edit";
    }

    @PostMapping("updateFlight")
    public String updateFlight(@ModelAttribute("flight") Flight flight, HttpSession session) {
        if (session.getAttribute("loggedInPassenger") == null) {
            return "redirect:/passenger/login";
        }
        flightDAO.updateFlight(flight);
        return "redirect:/flight/list";
    }

    @PostMapping("delete/{id}")
    public String deleteFlight(@PathVariable("id") Long id, HttpSession session) {
        if (session.getAttribute("loggedInPassenger") == null) {
            return "redirect:/passenger/login";
        }
        flightDAO.deleteFlight(id);
        return "redirect:/flight/list";
    }
}
