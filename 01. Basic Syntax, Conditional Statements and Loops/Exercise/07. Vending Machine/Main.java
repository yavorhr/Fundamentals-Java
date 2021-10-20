import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sum = 0;
        String command = scanner.nextLine();
        while (!("Start".equals(command))) {
            double money = Double.parseDouble(command);

            if (money == 0.1 || money == 0.2 || money == 0.5 || money == 1 || money == 2) {
                sum += money;
            } else {
                System.out.printf("Cannot accept %.2f%n", money);
            }
            command = scanner.nextLine();
        }

        boolean boughtItem = false;
        double price = 0.0;

        String purchase = scanner.nextLine();
        while (!("End".equals(purchase))) {
            switch (purchase) {
                case "Nuts":
                    price = 2.0;
                    boughtItem = true;
                    break;
                case "Water":
                    price = 0.7;
                    boughtItem = true;
                    break;
                case "Crisps":
                    price = 1.5;
                    boughtItem = true;
                    break;
                case "Soda":
                    price = 0.8;
                    boughtItem = true;
                    break;
                case "Coke":
                    price = 1.0;
                    boughtItem = true;
                    break;
                default:
                    break;
            }

            if (price > sum) {
                System.out.println("Sorry, not enough money");
            } else if (boughtItem) {
                sum -= price;
                System.out.printf("Purchased %s%n", purchase);
            } else {
                System.out.println("Invalid product");
            }
            purchase = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sum);
    }
}

