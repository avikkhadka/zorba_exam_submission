package org.example.SelfOwned;

public class SelfOwnedTwoBHKFlat {
    private SelfOwnedFlat flat;

    public SelfOwnedTwoBHKFlat() {}

    public SelfOwnedTwoBHKFlat(SelfOwnedFlat flat) {
        this.flat = flat;
    }

    public void setFlat(SelfOwnedFlat flat) {
        this.flat = flat;
    }

    public float calculatePlot(float length, float breadth, float height) {
        return length * breadth * height;
    }

    public float finalPriceOfFlat(float length, float breadth, float height) {
        return 30000 * calculatePlot(length, breadth, height);
    }

    public void displayDetails() {
        System.out.println("Property ID: " + flat.getPropertyId());
        System.out.println("Property Name: " + flat.getPropertyName());
    }
}
