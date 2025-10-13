package org.example.RentFlat;

public class RentOfOneBHKFlat {
    private RentOfFlat rentOfFlat;

    public RentOfOneBHKFlat() {}


    public RentOfOneBHKFlat(RentOfFlat rentOfFlat) {
        this.rentOfFlat = rentOfFlat;
    }

    // Setter for Setter DI
    public void setRentOfFlat(RentOfFlat rentOfFlat) {
        this.rentOfFlat = rentOfFlat;
    }

    // Method to calculate rent
    public int calculateRentOfFlat(int noOfPerson) {
        return 250 * noOfPerson;
    }

    // Display details using injected RentOfFlat
    public void displayDetails() {
        System.out.println("Property ID: " + rentOfFlat.getPropertyId());
        System.out.println("Property Name: " + rentOfFlat.getPropertyName());
    }
}
