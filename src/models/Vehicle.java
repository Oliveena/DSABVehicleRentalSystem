package models;

import java.io.Serializable;

// implements Seriazable interface for I/O mgmt
public abstract class Vehicle implements Serializable {
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
