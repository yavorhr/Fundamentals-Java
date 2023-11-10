import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int countOfPeople = Integer.parseInt(scanner.nextLine());
        double groupEnergy = Double.parseDouble(scanner.nextLine());

        double waterPerPlayer = Double.parseDouble(scanner.nextLine());
        double foodPerPlayer = Double.parseDouble(scanner.nextLine());

        double currentWater = getCurrentSupply(days, countOfPeople, waterPerPlayer);
        double currentFood = getCurrentSupply(days, countOfPeople, foodPerPlayer);

        boolean isSuccessful = true;

        for (int i = 1; i <= days; i++) {
            double energyLossPerDay = Double.parseDouble(scanner.nextLine());

            if (groupEnergy - energyLossPerDay <= 0) {
                isSuccessful = false;
                break;
            }

            groupEnergy -= energyLossPerDay;

            if (i % 2 == 0) {
                groupEnergy *= 1.05;
                currentWater *= 0.7;
            }

            if (i % 3 == 0) {
                groupEnergy *= 1.1;
                currentFood -= currentFood / countOfPeople;
            }
        }

        printResult(groupEnergy, currentWater, currentFood, isSuccessful);
    }

    private static double getCurrentSupply(int days, int countOfPeople, double waterPerPlayer) {
        return waterPerPlayer * countOfPeople * days;
    }

    private static void printResult(double groupEnergy, double currentWater, double currentFood, boolean isSuccessful) {
        if (isSuccessful) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", groupEnergy);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", currentFood, currentWater);
        }
    }
}



