package org.example;

public class Property {
    private int propertyId;
    private String propertyName;

    public Property() {}

    public int getPropertyId() { return propertyId; }
    public void setPropertyId(int propertyId) { this.propertyId = propertyId; }

    public String getPropertyName() { return propertyName; }
    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }

    public void displayPropertyDetails() {
        System.out.println("Property ID: " + propertyId);
        System.out.println("Property Name: " + propertyName);
    }
}
