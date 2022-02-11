import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] items = scanner.nextLine().split("\\|");
        double budget = Double.parseDouble(scanner.nextLine());
        List<Double> soldItems = new ArrayList<>();

        for (int i = 0; i < items.length; i++) {
            String[] item = items[i].split("->");
            String name = item[0];
            double price = Double.parseDouble(item[1]);

            switch (name) {
                case "Clothes":
                    if (price <= 50) {
                        if (budget - price >= 0) {
                            budget -= price;
                            soldItems.add(price);
                        }
                    }
                    break;
                case "Shoes":
                    if (price <= 35.50) {
                        if (budget - price >= 0) {
                            budget -= price;
                            soldItems.add(price);
                        }
                    }
                    break;
                case "Accessories":
                    if (price <= 25.50) {
                        if (budget - price >= 0) {
                            budget -= price;
                            soldItems.add(price);
                        }
                    }
                    break;
            }
        }
        double allProfit = 0;
        double sum = 0;
        for (int i = 0; i < soldItems.size(); i++) {
            double profit = soldItems.get(i) * 0.4;
            allProfit += profit;
            soldItems.set(i, profit + soldItems.get(i));

        }

        for (double price : soldItems) {
            System.out.printf("%.2f ", price);
            sum += price;
        }
        System.out.println();
        System.out.printf("Profit: %.2f%n", allProfit);
        if (budget + sum >= 150) {
            System.out.println("Hello, France!");
        } else {
            System.out.println("Time to go.");
        }
    }
}




































