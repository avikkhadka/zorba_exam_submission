package org.example.SelfOwned;

public class SelfOwnedThreeBHKFlat {
    private SelfOwnedFlat flat;

    public SelfOwnedThreeBHKFlat() {}

    public SelfOwnedThreeBHKFlat(SelfOwnedFlat flat) {
        this.flat = flat;
    }

    public void setFlat(SelfOwnedFlat flat) {
        this.flat = flat;
    }

    public float calculatePlot(float length, float breadth, float height) {
        return length * breadth * height;
    }

    public float finalPriceOfFlat(float length, float breadth, float height) {
        return 50000 * calculatePlot(length, breadth, height);
    }

    public void displayDetails() {
        System.out.println("Property ID: " + flat.getPropertyId());
        System.out.println("Property Name: " + flat.getPropertyName());
    }
}
