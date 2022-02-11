import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysAdventure = Integer.parseInt(scanner.nextLine());
        int playersCnt = Integer.parseInt(scanner.nextLine());
        double energyGroup = Double.parseDouble(scanner.nextLine());
        double waterPerDay = Double.parseDouble(scanner.nextLine());
        double foodPerDay = Double.parseDouble(scanner.nextLine());

        double waterGroup = waterPerDay * playersCnt * daysAdventure;
        double foodGroup = foodPerDay * playersCnt * daysAdventure;
        boolean isSuccessful = true;

        for (int i = 1; i <= daysAdventure; i++) {
            double energyLoss = Double.parseDouble(scanner.nextLine());
            if (energyGroup - energyLoss > 0) {
                energyGroup -= energyLoss;
            } else {
                isSuccessful = false;
                break;
            }

            if (i % 2 == 0) {
                energyGroup *= 1.05;
                waterGroup = waterGroup - waterGroup * 0.3;
            }

            if (i % 3 == 0) {
                energyGroup *= 1.1;
                foodGroup = foodGroup - (foodGroup / playersCnt);
            }
        }

        if (isSuccessful) {
            System.out.printf("You are ready for the quest. You will be left with - %.2f energy!", energyGroup);
        } else {
            System.out.printf("You will run out of energy. You will be left with %.2f food and %.2f water.", foodGroup, waterGroup);
        }

    }
}

































