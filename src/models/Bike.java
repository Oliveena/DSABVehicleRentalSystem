package models;

public class Bike extends Vehicle {
    private boolean hasCarrier;

    public Bike(String id, String brand, boolean hasCarrier) {
        super(id, brand);
        this.hasCarrier = hasCarrier;
    }

    @Override
    public void displayInfo() {
        System.out.println("Bike - ID: " + id + ", Brand: " + brand + ", Carrier: " + hasCarrier + ", Available: " + available);
    }
}
