import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double experienceToLevelUp = Double.parseDouble(scanner.nextLine());
        int battlesCnt = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        double earnedExp = 0;
        boolean levelUp = false;

        for (int i = 0; i < battlesCnt; i++) {
            double currentExp = Double.parseDouble(scanner.nextLine());
            counter++;

            if (counter % 3 == 0) {
                currentExp *= 1.15;
            }
            if (counter % 5 == 0) {
                currentExp *= 0.9;
            }
            earnedExp += currentExp;
            if (earnedExp >= experienceToLevelUp) {
                levelUp = true;
                break;
            }
        }

        if (levelUp) {
            System.out.printf("Player successfully collected his needed experience for %d battles.",counter);
        } else {
            System.out.printf("Player was not able to collect the needed experience, %.2f more needed.",experienceToLevelUp-earnedExp);
        }
    }
}



















