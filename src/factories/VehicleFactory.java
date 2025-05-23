package factories;

import models.*;

public class VehicleFactory {

    public static Car createCar(String id, String brand, int numDoors) {
        return new Car(id, brand, numDoors);
    }

    public static Bike createBike(String id, String brand, boolean hasCarrier) {
        return new Bike(id, brand, hasCarrier);
    }

    public static Truck createTruck(String id, String brand, int loadCapacity) {
        return new Truck(id, brand, loadCapacity);
    }
}
