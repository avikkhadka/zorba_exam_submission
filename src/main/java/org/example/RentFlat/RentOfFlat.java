package org.example.RentFlat;

public class RentOfFlat {
    private int propertyId;
    private String propertyName;

    public RentOfFlat() {}

    public RentOfFlat(int propertyId, String propertyName) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
    }

    // Getters and setters
    public int getPropertyId() { return propertyId; }
    public void setPropertyId(int propertyId) { this.propertyId = propertyId; }

    public String getPropertyName() { return propertyName; }
    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }
}
