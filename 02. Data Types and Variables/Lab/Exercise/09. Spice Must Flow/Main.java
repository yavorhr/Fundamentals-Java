import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());

        int days = 0;
        int collectedSpice = 0;

        while (startingYield > 0) {
            collectedSpice += startingYield;
            collectedSpice -= 26;
            startingYield -= 10;
            days++;

            if (startingYield < 100) {
                collectedSpice -= 26;
                break;
            }
        }

        System.out.println(days);
        System.out.println(collectedSpice);
    }
}
