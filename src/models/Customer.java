package models;

import data.RentalRecord;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String id;
    private String name;
    private List<RentalRecord> rentalHistory = new ArrayList<>();

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addRentalRecord(RentalRecord record) {
        rentalHistory.add(record);
    }

    public List<RentalRecord> getRentalHistory() {
        return rentalHistory;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}
