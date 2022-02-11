import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double journeyCost = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());

        double savings = 0;
        for (int i = 1; i <= months; i++) {
            if (i != 1 && i % 2 != 0) {
                savings = savings - 0.16 * savings;
            }

            if (i % 4 == 0) {
                savings = savings + savings * 0.25;
            }
            savings += 0.25 * journeyCost;
        }

        if (savings >= journeyCost) {
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", savings - journeyCost);
        } else {
            System.out.printf("Sorry. You need %.2flv. more.", journeyCost - savings);
        }
    }
}















