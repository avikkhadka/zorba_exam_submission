package org.zorba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrainController {

    @PostMapping("/save")
    public String saveTrain(
            @RequestParam("trainName") String trainName,
            @RequestParam("noOfCoaches") int noOfCoaches,
            @RequestParam("startStation") String startStation,
            @RequestParam("endStation") String endStation,
            @RequestParam("trainType") String trainType,
            @RequestParam("avgSpeed") double avgSpeed
    ) {
        // Print all submitted values
        System.out.println("Train form submitted!");
        System.out.println("Train Name: " + trainName);
        System.out.println("No of Coaches: " + noOfCoaches);
        System.out.println("Start Station: " + startStation);
        System.out.println("End Station: " + endStation);
        System.out.println("Train Type: " + trainType);
        System.out.println("Average Speed: " + avgSpeed + " km/h");

        // For now, just return the same form
        return "trainform"; // maps to trainform.jsp
    }
}
