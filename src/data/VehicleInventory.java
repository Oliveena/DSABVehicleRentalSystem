package data;

import models.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleInventory {
    private List<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Vehicle> getAvailableVehicles(Class<?> type) {
        return vehicles.stream()
                .filter(v -> type.isInstance(v) && v.isAvailable())
                .collect(Collectors.toList());
    }

    public Vehicle getVehicleById(String id) {
        return vehicles.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public boolean removeVehicleById(String vehicleId) {
        return vehicles.removeIf(v -> v.getId().equals(vehicleId));
    }
}
