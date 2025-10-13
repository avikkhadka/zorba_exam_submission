package org.example;

import org.example.RentFlat.*;
import org.example.SelfOwned.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Execution {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // ===== RentOfFlats =====
        RentOfOneBHKFlat oneBHK = (RentOfOneBHKFlat) context.getBean("oneBHKFlat");
        RentOfTwoBHKFlat twoBHK = (RentOfTwoBHKFlat) context.getBean("twoBHKFlat");
        RentOfThreeBHKFlat threeBHK = (RentOfThreeBHKFlat) context.getBean("threeBHKFlat");

        System.out.println("***************Details for Rent Flats***************");
        oneBHK.displayDetails();
        System.out.println("Rent for 2 persons: " + oneBHK.calculateRentOfFlat(2));
        System.out.println();

        twoBHK.displayDetails();
        System.out.println("Rent for 3 persons: " + twoBHK.calculateRentOfFlat(3));
        System.out.println();

        threeBHK.displayDetails();
        System.out.println("Rent for 4 persons: " + threeBHK.calculateRentOfFlat(4));
        System.out.println();

        //*************SelfOwned Flats*******************
        SelfOwnedOneBHKFlat oneBHKSelf = (SelfOwnedOneBHKFlat) context.getBean("oneBHKSelfOwned");
        SelfOwnedTwoBHKFlat twoBHKSelf = (SelfOwnedTwoBHKFlat) context.getBean("twoBHKSelfOwned");
        SelfOwnedThreeBHKFlat threeBHKSelf = (SelfOwnedThreeBHKFlat) context.getBean("threeBHKSelfOwned");

        System.out.println("***************Details for SelfOwned Flats*******************");
        oneBHKSelf.displayDetails();
        System.out.println("Plot area: " + oneBHKSelf.calculatePlot(10, 20, 3));
        System.out.println("Final Price: " + oneBHKSelf.finalPriceOfFlat(10, 20, 3));
        System.out.println();

        twoBHKSelf.displayDetails();
        System.out.println("Plot area: " + twoBHKSelf.calculatePlot(15, 25, 3));
        System.out.println("Final Price: " + twoBHKSelf.finalPriceOfFlat(15, 25, 3));
        System.out.println();

        threeBHKSelf.displayDetails();
        System.out.println("Plot area: " + threeBHKSelf.calculatePlot(20, 30, 3));
        System.out.println("Final Price: " + threeBHKSelf.finalPriceOfFlat(20, 30, 3));
        System.out.println();


    }
}
