package models;

public class Car extends Vehicle {
    private int numDoors;

    public Car(String id, String brand, int numDoors) {
        super(id, brand);
        this.numDoors = numDoors;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car - ID: " + id + ", Brand: " + brand + ", Doors: " + numDoors + ", Available: " + available);
    }
}
