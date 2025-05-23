package factories;

import models.Customer;

public class CustomerFactory {

    public static Customer createCustomer(String id, String name) {
        return new Customer(id, name);
    }
}
