import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        double price1kgFloor = Double.parseDouble(scanner.nextLine());

        double price1packEggs = price1kgFloor * 0.75;
        double milkPrice = price1kgFloor * 1.25;
        double milkPriceKozunac = milkPrice * 0.25;

        double kozunacCost = price1kgFloor + price1packEggs + milkPriceKozunac;
        int kozunacsCount = 0;
        int coloredEggs = 0;

        while (budget > kozunacCost ) {
            budget -= kozunacCost;
            kozunacsCount++;
            coloredEggs += 3;
            if (kozunacsCount % 3 == 0) {
                int lostEggs = kozunacsCount - 2;
                coloredEggs -= lostEggs;
            }

        }
        System.out.printf("You made %d cozonacs! Now you have %d eggs and %.2fBGN left.", kozunacsCount, coloredEggs, budget);
    }
}



































