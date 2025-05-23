import data.RentalService;
import data.VehicleInventory;
import factories.CustomerFactory;
import factories.VehicleFactory;
import models.*;
import data.*;

public class Main {
    public static void main(String[] args) {
        VehicleInventory inventory = new VehicleInventory();
        RentalService rentalService = new RentalService(inventory);

        // Add vehicles
        Vehicle car = VehicleFactory.createCar("C1", "Toyota", 4);
        Vehicle bike = VehicleFactory.createBike("B1", "Yamaha", true);
        Vehicle truck = VehicleFactory.createTruck("T1", "Volvo", 10000);
        inventory.addVehicle(car);
        inventory.addVehicle(bike);
        inventory.addVehicle(truck);

        // Register customer
        Customer ali = CustomerFactory.createCustomer("U1", "Ingrid Johansdottir");
        Customer zara = CustomerFactory.createCustomer("U2", "Gustav Mandelbaum");
        rentalService.registerCustomer(ali);
        rentalService.registerCustomer(zara);

        // Rent a vehicle
        rentalService.rentVehicle("U1", "C1");

        // Return a vehicle
        rentalService.returnVehicle("C1");

        // View rental history
        rentalService.viewCustomerHistory("U1");

        boolean removedVehicle = inventory.removeVehicleById("B1");
        System.out.println(removedVehicle ? "Vehicle removed from inventory." : "Vehicle not found.");

        // 🗑 Remove customer
        boolean removedCustomer = rentalService.removeCustomerById("U2");
        System.out.println(removedCustomer ? "Customer removed from records." : "Customer not found.");
    }
}
