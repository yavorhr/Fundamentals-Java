import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int plunderPerDay = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double collectedPlunder = 0.0;

        collectedPlunder = addPlunder(days, plunderPerDay, collectedPlunder);

        printResult(expectedPlunder, collectedPlunder);

    }

    private static void printResult(double expectedPlunder, double collectedPlunder) {
        if (collectedPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", collectedPlunder);
        } else {
            double percents = (collectedPlunder / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", percents);
        }
    }

    private static double addPlunder(int days, int plunderPerDay, double collectedPlunder) {
        for (int i = 1; i <= days; i++) {
            double currentPlunder = plunderPerDay;

            if (i % 3 == 0) {
                currentPlunder *= 1.5;
            }

            collectedPlunder += currentPlunder;

            if (i % 5 == 0) {
                collectedPlunder *= 0.7;
            }
        }
        return collectedPlunder;
    }
}




