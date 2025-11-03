package flightbookingsystem.controller;

import flightbookingsystem.entity.Passenger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PassengerController {

    @GetMapping("/passenger/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("passenger", new Passenger());
        return "passenger_register";
    }

}
