import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int lostHeadset = lostGamesCount / 2;
        int lostMouse = lostGamesCount / 3;
        int keyboardLost = lostGamesCount / 6;
        int displayLost = 0;

        for (int i = 1; i <= keyboardLost; i++) {
            if (i % 2 == 0) {
                displayLost++;
            }
        }

        double costs = headsetPrice * lostHeadset + mousePrice * lostMouse + keyboardPrice * keyboardLost + displayLost * displayPrice;

        System.out.printf("Rage expenses: %.2f lv.", costs);
    }
}


