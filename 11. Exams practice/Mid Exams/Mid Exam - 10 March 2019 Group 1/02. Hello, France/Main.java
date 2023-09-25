import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");
        double budget = Double.parseDouble(scanner.nextLine());
        List<Double> boughtItems = new ArrayList<>();

        for (String string : input) {
            String[] tokens = string.split("->");
            String type = tokens[0];
            double price = Double.parseDouble(tokens[1]);

            switch (type) {
                case "Clothes" -> {
                    boolean enoughBudget = checkIfBudgetIsEnough(price, budget);
                    if (enoughBudget && priceIsInRange(price, 50)) {
                        budget = addItem(budget, boughtItems, price);
                    }
                }
                case "Shoes" -> {
                    boolean enoughBudget = checkIfBudgetIsEnough(price, budget);
                    if (enoughBudget && priceIsInRange(price, 35)) {
                        budget = addItem(budget, boughtItems, price);
                    }
                }
                case "Accessories" -> {
                    boolean enoughBudget = checkIfBudgetIsEnough(price, budget);
                    if (enoughBudget && priceIsInRange(price, 20.5)) {
                        budget = addItem(budget, boughtItems, price);
                    }
                }
            }
        }

        List<Double> soldItems = addProfit(boughtItems);

        double sumOfBoughtItems = getSum(boughtItems);
        double sumOfSoldItems = getSum(soldItems);
        double newBudget = budget + sumOfSoldItems;

        if (newBudget >= 150) {
            printResult(sumOfSoldItems, sumOfBoughtItems, "Hello, France!", soldItems);
        } else {
            printResult(sumOfSoldItems, sumOfBoughtItems, "Time to go.", soldItems);
        }
    }

    private static List<Double> addProfit(List<Double> boughtItems) {
        return
                boughtItems
                        .stream()
                        .map(item -> item *= 1.4)
                        .collect(Collectors.toList());
    }

    private static double getSum(List<Double> boughtItems) {
        return
                boughtItems
                        .stream()
                        .mapToDouble(Double::doubleValue)
                        .sum();
    }

    private static void printResult(double sumSoldItems, double sumBoughtItems, String result, List<Double> soldItems) {
        soldItems.forEach(item -> System.out.printf("%.2f ", item));
        System.out.println();
        System.out.printf("Profit: %.2f\n", sumSoldItems - sumBoughtItems);
        System.out.println(result);
    }

    private static double addItem(double budget, List<Double> soldItems, double price) {
        budget -= price;
        soldItems.add(price);
        return budget;
    }

    private static boolean priceIsInRange(double currentPrice, double bound) {
        return currentPrice <= bound;
    }

    private static boolean checkIfBudgetIsEnough(double price, double budget) {
        return budget - price >= 0;
    }
}




