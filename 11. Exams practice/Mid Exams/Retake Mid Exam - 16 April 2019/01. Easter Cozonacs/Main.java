import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double price1kgFloor = Double.parseDouble(scanner.nextLine());

        double price1packEggs = price1kgFloor * 0.75;
        double milkPrice = price1kgFloor * 1.25;
        double milkPriceCozonac = milkPrice * 0.25;

        double cozonacsCost = getCozonacsCost(price1kgFloor, price1packEggs, milkPriceCozonac);

        int cozonacsCount = 0;
        int coloredEggs = 0;

        while (budgetIsEnough(budget, cozonacsCost)) {
            budget -= cozonacsCost;
            cozonacsCount++;
            coloredEggs += 3;

            if (cozonacsCount % 3 == 0) {
                int lostEggs = cozonacsCount - 2;
                coloredEggs -= lostEggs;
            }
        }

        printResult(budget, cozonacsCount, coloredEggs);
    }

    private static void printResult(double budget, int cozonacsCount, int coloredEggs) {
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.", cozonacsCount, coloredEggs, budget);
    }

    private static boolean budgetIsEnough(double budget, double cozonacsCost) {
        return budget >= cozonacsCost;
    }

    private static double getCozonacsCost(double price1kgFloor, double price1packEggs, double milkPriceCozonac) {
        return price1kgFloor + price1packEggs + milkPriceCozonac;
    }
}


