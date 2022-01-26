import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Vehicle> vehicles = new ArrayList<>();
        String addVehicle = scanner.nextLine();
        while (!"End".equals(addVehicle)) {
            String[] vehicleTokens = addVehicle.split(" ");
            String typeOfVehicle = vehicleTokens[0];
            String model = vehicleTokens[1];
            String color = vehicleTokens[2];
            double horsepower = Double.parseDouble(vehicleTokens[3]);
            Vehicle currentVehicle = new Vehicle(typeOfVehicle, model, color, horsepower);
            vehicles.add(currentVehicle);
            addVehicle = scanner.nextLine();
        }

        String carModel = scanner.nextLine();
        while (!"Close the Catalogue".equals(carModel)) {
            for (Vehicle vehicle : vehicles) {
                if (carModel.equals(vehicle.getModel())) {
                    System.out.println(vehicle.toString());
                }
            }
            carModel = scanner.nextLine();
        }

        double averageHpCars = averageHp(vehicles, "car");
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageHpCars);
        double averageHptrucks = averageHp(vehicles, "truck");
        System.out.printf("Trucks have average horsepower of: %.2f.", averageHptrucks);
    }

    private static double averageHp(List<Vehicle> vehicles, String vehicleType) {
        int vehicleCnt = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicleType.equals(vehicle.getTypeOfVehicle())) {
                vehicleCnt++;
            }
        }

        double averageHp = 0;
        for (Vehicle vehicle : vehicles) {
            if (vehicleType.equals(vehicle.getTypeOfVehicle())) {
                averageHp = averageHp + vehicle.getHorsepower();
            }
        }

        averageHp = averageHp / vehicleCnt;
        if (vehicleCnt==0){
            return 0;
        }
        return averageHp;
    }
}
