import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Vehicle> vehicles = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {

            addVehicleToList(vehicles, input);

            input = scanner.nextLine();
        }

        String modelInput = scanner.nextLine();
        while (!modelInput.equals("Close the Catalogue")) {
            String finalModelInput = modelInput;

            printVehicleDataByModel(vehicles, finalModelInput);

            modelInput = scanner.nextLine();
        }

        double avgCarsHorsePower = getAverageVehicleHorsePower(vehicles, "car");
        double avgTrucksHorsePower = getAverageVehicleHorsePower(vehicles, "truck");

        printAvgHorsePower("Cars", avgCarsHorsePower);
        printAvgHorsePower("Trucks", avgTrucksHorsePower);
    }

    private static void printVehicleDataByModel(List<Vehicle> vehicles, String finalModelInput) {
        vehicles.stream()
                .filter(v -> v.getModel().equals(finalModelInput))
                .forEach(System.out::println);
    }

    private static void printAvgHorsePower(String vehicleType, double averageCarsHorsePower) {
        System.out.printf("%s have average horsepower of: %.2f.\n", vehicleType, averageCarsHorsePower);
    }

    private static double getAverageVehicleHorsePower(List<Vehicle> vehicles, String car) {
        return vehicles.stream().
                filter(v -> v.getTypeOfVehicle().equalsIgnoreCase(car))
                .mapToDouble(Vehicle::getHorsePower)
                .average()
                .orElse(0);
    }

    private static void addVehicleToList(List<Vehicle> vehicles, String input) {
        String[] tokens = input.split(" ");
        String typeOfVehicle = tokens[0];
        String model = tokens[1];
        String color = tokens[2];
        int horsePowers = Integer.parseInt(tokens[3]);
        Vehicle vehicle = new Vehicle(typeOfVehicle, model, color, horsePowers);
        vehicles.add(vehicle);
    }
}



