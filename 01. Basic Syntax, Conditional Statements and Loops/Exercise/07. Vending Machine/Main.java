import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        double sumOfCoins = 0.0;

        while (!command.equals("Start")) {
            double coin = Double.parseDouble(command);

            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                sumOfCoins += coin;
            } else {
                System.out.printf("Cannot accept %.2f\n", coin);
            }
            command = scanner.nextLine();
        }

        String purchaseInput = scanner.nextLine();
        while (!purchaseInput.equals("End")) {

            boolean buyArticle = false;
            double productPrice = 0.0;

            switch (purchaseInput) {
                case "Nuts" -> {
                    productPrice = 2.0;
                    buyArticle = true;
                }
                case "Water" -> {
                    productPrice = 0.7;
                    buyArticle = true;
                }
                case "Crisps" -> {
                    productPrice = 1.5;
                    buyArticle = true;
                }
                case "Soda" -> {
                    productPrice = 0.8;
                    buyArticle = true;
                }
                case "Coke" -> {
                    productPrice = 1.0;
                    buyArticle = true;
                }
            }

            boolean enoughCoins = sumOfCoins - productPrice > 0;

            if (buyArticle && enoughCoins) {
                sumOfCoins -= productPrice;
                System.out.printf("Purchased %s\n", purchaseInput);
            } else if (!enoughCoins && buyArticle) {
                System.out.println("Sorry, not enough money\n" + "Change: " + sumOfCoins);
            } else {
                System.out.println("Invalid product");
            }
            purchaseInput = scanner.nextLine();
        }
    }
}