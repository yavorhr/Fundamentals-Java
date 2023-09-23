import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int requiredExp = Integer.parseInt(scanner.nextLine());
        int battlesCount = Integer.parseInt(scanner.nextLine());

        double currentExp = 0;

        for (int i = 1; i <= battlesCount; i++) {
            double experiencePerBattle = Double.parseDouble(scanner.nextLine());

            currentExp = addExpPerBattle(currentExp, i, experiencePerBattle);

            if (currentExp >= requiredExp) {
                System.out.printf("Player successfully collected his needed experience for %d battles.", i);
                break;
            }
        }

        if (requiredExp > currentExp) {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.", requiredExp - currentExp);
        }
    }

    private static double addExpPerBattle(double currentExp, int i, double experiencePerBattle) {
        if (i % 3 == 0) {
            currentExp += experiencePerBattle * 1.15;
        } else if (i % 5 == 0) {
            currentExp += experiencePerBattle * 0.9;
        } else {
            currentExp += experiencePerBattle;
        }
        return currentExp;
    }
}




