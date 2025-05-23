package models;

public abstract class Vehicle {
    protected String id;
    protected String brand;
    protected boolean available = true;

    public Vehicle(String id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    public String getId() { return id; }

    public abstract void displayInfo();
}
