package org.zorba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PassengerController {

    @PostMapping("/passenger/register")
    public String registerPassenger(
            @RequestParam("name") String name,
            @RequestParam("age") int age,
            @RequestParam("email") String email
    ) {
        // Print submitted values to console
        System.out.println("---- Passenger Form Submitted ----");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("---------------------------------");

        // Return view name (JSP file)
        return "passengerform"; // maps to passengerForm.jsp in webapp/
    }
}
