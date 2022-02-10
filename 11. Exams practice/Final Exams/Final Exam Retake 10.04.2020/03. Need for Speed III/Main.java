import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> mapMileage = new LinkedHashMap<>();
        Map<String, Integer> mapFuel = new LinkedHashMap<>();

        int countCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countCars; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String carModel = tokens[0];
            int mileAge = Integer.parseInt(tokens[1]);
            int fuel = Integer.parseInt(tokens[2]);

            mapMileage.put(carModel, mileAge);
            mapFuel.put(carModel, fuel);
        }

        String input = scanner.nextLine();
        while (!"Stop".equals(input)) {

            String[] tokens = input.split(" : ");
            String command = tokens[0];
            String carModel = tokens[1];

            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(tokens[2]);
                    int fuel = Integer.parseInt(tokens[3]);

                    if (mapFuel.get(carModel) >= fuel) {
                        int newFuel = mapFuel.get(carModel) - fuel;
                        mapFuel.put(carModel, newFuel);

                        int newMileage = mapMileage.get(carModel) + distance;
                        mapMileage.put(carModel, newMileage);

                        System.out.println(String.format("%s driven for %d kilometers. %d liters of fuel consumed.", carModel, distance, fuel));

                        if (mapMileage.get(carModel) >= 100000) {
                            mapMileage.remove(carModel);
                            System.out.println(String.format("Time to sell the %s!", carModel));
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;
                case "Refuel":
                    int refuel = Integer.parseInt(tokens[2]);

                    if (mapFuel.get(carModel) + refuel >= 75) {
                        int oldFuel = mapFuel.get(carModel);
                        mapFuel.put(carModel, 75);
                        System.out.println(String.format("%s refueled with %d liters", carModel, 75 - oldFuel));
                    } else {
                        int newFuel = mapFuel.get(carModel) + refuel;
                        mapFuel.put(carModel, newFuel);
                        System.out.println(String.format("%s refueled with %d liters", carModel, refuel));
                    }
                    break;
                case "Revert":
                    int revertKm = Integer.parseInt(tokens[2]);
                    if (mapMileage.get(carModel) - revertKm > 10000) {
                        int newMileage = mapMileage.get(carModel) - revertKm;
                        mapMileage.put(carModel, newMileage);
                        System.out.println(String.format("%s mileage decreased by %d kilometers", carModel, revertKm));
                    } else {
                        mapMileage.put(carModel, 10000);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        mapMileage
                .entrySet()
                .stream()
                .sorted((c1, c2) -> {
                            int result = Integer.compare(c2.getValue(), c1.getValue());
                            if (result == 0) {
                                result = c1.getKey().compareTo(c2.getKey());
                            }
                            return result;
                        }
                ).forEach(c -> System.out.println(String.format("%s -> Mileage: %d kms, Fuel in the tank: %d lt.", c.getKey(), c.getValue(), mapFuel.get(c.getKey()))
        ));
    }
}


