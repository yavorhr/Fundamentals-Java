import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());   //111

        int allSpice = 0;
        int dayCnt = 0;

        while (startingYield >= 100) {
            int currentSpice = startingYield - 26;
            allSpice += currentSpice;
            dayCnt++;

            startingYield -= 10;

            if (startingYield < 100) {
                allSpice -= 26;
            }
        }

        System.out.println(dayCnt);
        System.out.println(allSpice);
    }
}
