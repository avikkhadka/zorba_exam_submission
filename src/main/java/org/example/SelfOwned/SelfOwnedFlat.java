package org.example.SelfOwned;

public class SelfOwnedFlat {
    private int propertyId;
    private String propertyName;

    public SelfOwnedFlat() {}

    public SelfOwnedFlat(int propertyId, String propertyName) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
    }

    public int getPropertyId() { return propertyId; }
    public void setPropertyId(int propertyId) { this.propertyId = propertyId; }

    public String getPropertyName() { return propertyName; }
    public void setPropertyName(String propertyName) { this.propertyName = propertyName; }
}
