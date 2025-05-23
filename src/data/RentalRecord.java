package data;

import models.Customer;
import models.Vehicle;

import java.time.LocalDate;

public class RentalRecord {
    private Vehicle vehicle;
    private Customer customer;
    private LocalDate rentalDate;
    private LocalDate returnDate;

    public RentalRecord(Vehicle vehicle, Customer customer) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentalDate = LocalDate.now();
    }

    public void markReturned() {
        this.returnDate = LocalDate.now();
        vehicle.setAvailable(true);
    }

    @Override
    public String toString() {
        return customer.getName() + " rented " + vehicle.getId() + " on " + rentalDate +
                (returnDate != null ? ", returned on " + returnDate : ", not yet returned");
    }
}
