import java.util.*;

public class Main {
    private static final int MAX_LITER_CAPACITY = 75;
    private static final int MAX_MILEAGE_PER_YEAR = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carsCount = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> mileagesMap = new HashMap<>();
        Map<String, Integer> fuelsMap = new HashMap<>();

        for (int i = 0; i < carsCount; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String car = tokens[0];
            int km = Integer.parseInt(tokens[1]);
            int fuelInTank = Integer.parseInt(tokens[2]);

            mileagesMap.put(car, km);
            fuelsMap.put(car, fuelInTank);
        }

        String input = scanner.nextLine();
        while (!"Stop".equals(input)) {
            String[] tokens = input.split(" : ");
            String command = tokens[0];
            String currentCar = tokens[1];

            switch (command) {
                case "Drive" -> {
                    int distanceInput = Integer.parseInt(tokens[2]);
                    int neededFuel = Integer.parseInt(tokens[3]);

                    int currentFuel = fuelsMap.get(currentCar);
                    int currentMileage = mileagesMap.get(currentCar);

                    if (currentFuel < neededFuel) {
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        currentFuel -= neededFuel;
                        currentMileage += distanceInput;

                        fuelsMap.put(currentCar, currentFuel);
                        mileagesMap.put(currentCar, currentMileage);

                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n", currentCar, distanceInput, neededFuel);
                    }

                    if (currentMileage >= 100000) {
                        mileagesMap.remove(currentCar);
                        fuelsMap.remove(currentCar);
                        System.out.printf("Time to sell the %s!\n", currentCar);
                    }

                }
                case "Refuel" -> {
                    int fuelInput = Integer.parseInt(tokens[2]);
                    int currentFuel = fuelsMap.get(currentCar);

                    int diff = fuelInput;

                    if (currentFuel + fuelInput > MAX_LITER_CAPACITY) {
                        diff = MAX_LITER_CAPACITY - currentFuel;
                        currentFuel = MAX_LITER_CAPACITY;
                    }

                    fuelsMap.put(currentCar, currentFuel);

                    System.out.printf("%s refueled with %d liters\n", currentCar, diff);
                }
                case "Revert" -> {
                    int kmInput = Integer.parseInt(tokens[2]);
                    int currentKm = mileagesMap.get(currentCar);

                    currentKm -= kmInput;

                    if (currentKm < MAX_MILEAGE_PER_YEAR) {
                        currentKm = MAX_MILEAGE_PER_YEAR;
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers\n", currentCar, kmInput);
                    }
                    mileagesMap.put(currentCar, currentKm);
                }
            }
            input = scanner.nextLine();
        }

        printResult(mileagesMap, fuelsMap);
    }

    private static void printResult(Map<String, Integer> mileagesMap, Map<String, Integer> fuelsMap) {
        mileagesMap
                .entrySet()
                .stream()
                .sorted((c1, c2) -> {
                    int result = c2.getValue() - c1.getValue();

                    if (result == 0) {
                        result = c1.getKey().compareTo(c2.getKey());
                    }
                    return result;
                })
                .forEach(car ->
                        System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n",
                                car.getKey(),
                                car.getValue(),
                                fuelsMap.get(car.getKey())));
    }
}


