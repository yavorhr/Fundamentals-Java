import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());

        double savings = calcSavings(budget, months);

        printResult(savings,budget);
    }

    private static double calcSavings(double budget, int months) {
        double savings = 0.0;

        for (int i = 1; i <= months; i++) {

            if (i != 1 && i % 2 != 0) {
                savings *= 0.84;
            }

            if (i % 4 == 0) {
                savings *= 1.25;
            }
            savings += budget * 0.25;
        }
        return savings;
    }

    private static void printResult(double savings, double budget){
        double diff = Math.abs(savings - budget);

        if (savings >= budget) {
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.\n", diff);
        } else {
            System.out.printf("Sorry. You need %.2flv. more.",diff);
        }

    }
}
