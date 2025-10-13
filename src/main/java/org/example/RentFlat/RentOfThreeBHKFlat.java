package org.example.RentFlat;

public class RentOfThreeBHKFlat {
    private RentOfFlat rentOfFlat;  // DI target

    public RentOfThreeBHKFlat() {}

    // Constructor DI
    public RentOfThreeBHKFlat(RentOfFlat rentOfFlat) {
        this.rentOfFlat = rentOfFlat;
    }

    // Setter DI
    public void setRentOfFlat(RentOfFlat rentOfFlat) {
        this.rentOfFlat = rentOfFlat;
    }

    // Method to calculate rent
    public int calculateRentOfFlat(int noOfPerson) {
        return 600 * noOfPerson;
    }

    public void displayDetails() {
        System.out.println("Property ID: " + rentOfFlat.getPropertyId());
        System.out.println("Property Name: " + rentOfFlat.getPropertyName());

    }
}
