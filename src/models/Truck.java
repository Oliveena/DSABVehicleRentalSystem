package models;

public class Truck extends Vehicle {
    private int loadCapacity;

    public Truck(String id, String brand, int loadCapacity) {
        super(id, brand);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo() {
        System.out.println("Truck - ID: " + id + ", Brand: " + brand + ", Load Capacity: " + loadCapacity + "kg, Available: " + available);
    }
}
