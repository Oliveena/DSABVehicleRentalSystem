package data;

import models.Vehicle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileIOService {

    // executor interface for managing threads
    // https://www.baeldung.com/thread-pool-java-and-guava
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    // saving Vehicle objects to a file
    public static void saveVehiclesSerialized(List<Vehicle> vehicles, String filename) {
        Runnable task = () -> {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
                out.writeObject(vehicles);
                System.out.println("Serialized vehicles to " + filename);
            } catch (IOException e) {
                System.err.println("Error saving vehicles:");
                e.printStackTrace();
            }
        };
        executor.submit(task);
    }

    // avoiding error warnings
    @SuppressWarnings("unchecked")
    // loading Vehicle objects from file
    public static List<Vehicle> loadVehiclesSerialized(String filename) {
        // trying to instantiate a new stream
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            // returning Vehicles
            return (List<Vehicle>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // catching errors
            System.err.println("Error loading vehicles:");
            e.printStackTrace();
            // creating a new array
            return new ArrayList<>();
        }
    }

    // always shutting down executor interface
    public static void shutdown() {
        executor.shutdown();
    }
}
