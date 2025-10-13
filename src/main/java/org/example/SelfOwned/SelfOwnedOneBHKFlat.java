package org.example.SelfOwned;

public class SelfOwnedOneBHKFlat {
    private SelfOwnedFlat flat;

    // Constructor DI
    public SelfOwnedOneBHKFlat(SelfOwnedFlat flat) {
        this.flat = flat;
    }

    // Setter DI
    public void setFlat(SelfOwnedFlat flat) {
        this.flat = flat;
    }

    public float calculatePlot(float length, float breadth, float height) {
        return length * breadth * height;
    }

    public float finalPriceOfFlat(float length, float breadth, float height) {
        return 10000 * calculatePlot(length, breadth, height);
    }

    public void displayDetails() {
        System.out.println("Property ID: " + flat.getPropertyId());
        System.out.println("Property Name: " + flat.getPropertyName());
    }
}
