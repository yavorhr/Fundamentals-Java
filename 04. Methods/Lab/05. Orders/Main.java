import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        totalSum(product, quantity);
    }

    private static void totalSum(String product, int quantity) {
        double price = 0.0;

        switch (product) {
            case "coffee":
                price = quantity * 1.50;
                break;
            case "water":
                price = quantity * 1.00;
                break;
            case "coke":
                price = 1.40 * quantity;
                break;
            case "snacks":
                price = 2.00 * quantity;
                break;
            default:
                break;
        }

        System.out.printf("%.2f", price);
    }
}
