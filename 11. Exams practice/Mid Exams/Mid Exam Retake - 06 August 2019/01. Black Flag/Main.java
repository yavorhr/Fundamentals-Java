import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());
        double totalPlunder = 0;

        for (int i = 1; i <= days; i++) {
            double currentPlunder = dailyPlunder * 1.0;
            if (i % 3 == 0) {
                currentPlunder = currentPlunder + currentPlunder * 0.5;
            }

            totalPlunder += currentPlunder;

            if (i % 5 == 0) {
                totalPlunder *= 0.7;
            }
        }
        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.%n", totalPlunder);
        } else {
            double percentage = (totalPlunder / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.", percentage);
        }
    }
}




















