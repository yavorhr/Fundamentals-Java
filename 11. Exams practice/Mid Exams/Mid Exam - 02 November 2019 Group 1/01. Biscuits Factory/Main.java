import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int biscuitsPerWorker = readInteger(scanner);
        int workersCount = readInteger(scanner);
        int totalAnotherFactory = readInteger(scanner);

        int dailyProduction = biscuitsPerWorker * workersCount;
        double totalProduction = totalBiscuitsCalc(dailyProduction);

        printBiscuitsProd(totalProduction);

        double difference = totalProduction - totalAnotherFactory * 1.0;
        double percent = Math.abs((difference / totalAnotherFactory) * 100);

        printPercent(difference,percent);
    }

    private static void printBiscuitsProd(double totalProduction) {
        System.out.printf("You have produced %.0f biscuits for the past month.\n", totalProduction);
    }

    private static void printPercent(double difference, double percent){
        if (difference > 0) {
            System.out.printf("You produce %.2f percent more biscuits.\n", percent);
        } else {
            System.out.printf("You produce %.2f percent less biscuits.\n", percent);
        }
    }

    private static int readInteger(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static double totalBiscuitsCalc(int dailyProduction) {
        double totalBiscuits = 0;

        int days = 1;
        while (days <= 30) {
            if (days % 3 == 0) {
                totalBiscuits += Math.floor(dailyProduction * 0.75);
            } else {
                totalBiscuits += dailyProduction;
            }
            days++;
        }
        return totalBiscuits;
    }
}


