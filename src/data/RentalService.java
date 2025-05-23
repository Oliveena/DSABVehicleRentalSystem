package data;

import models.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RentalService {
    private VehicleInventory inventory;
    private HashMap<String, Customer> customers = new HashMap<>();
    private List<RentalRecord> allRentals = new ArrayList<>();

    public RentalService(VehicleInventory inventory) {
        this.inventory = inventory;
    }

    public void registerCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }

    public boolean removeCustomerById(String customerId) {
        return customers.remove(customerId) != null;
    }


    public void rentVehicle(String customerId, String vehicleId) {
        Customer customer = customers.get(customerId);
        Vehicle vehicle = inventory.getVehicleById(vehicleId);

        if (customer == null || vehicle == null || !vehicle.isAvailable()) {
            System.out.println("Invalid rental operation! Please try again");
            return;
        }

        vehicle.setAvailable(false);
        RentalRecord record = new RentalRecord(vehicle, customer);
        allRentals.add(record);
        customer.addRentalRecord(record);

        System.out.println("Rental: " + customer.getName() + " rented vehicle " + vehicleId);
    }

    public void returnVehicle(String vehicleId) {
        for (RentalRecord record : allRentals) {
            if (record.toString().contains(vehicleId) && record.toString().contains("not yet returned")) {
                record.markReturned();
                System.out.println("Vehicle " + vehicleId + " returned.");
                return;
            }
        }
        System.out.println("Vehicle ID: " + vehicleId + " not currently rented.");
    }

    public void viewCustomerHistory(String customerId) {
        Customer customer = customers.get(customerId);
        if (customer != null) {
            System.out.println("Rental history for " + customer.getName() + ":");
            customer.getRentalHistory().forEach(System.out::println);
        } else {
            System.out.println("Customer not found.");
        }
    }
}
