import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int currencyInput = Integer.parseInt(scanner.nextLine());
        double poundsInUSD = calculateExchangeRate(currencyInput);
        printResult(poundsInUSD);
    }

    private static void printResult(double poundsInUSD) {
        System.out.printf("%.3f", poundsInUSD);
    }

    private static double calculateExchangeRate(int currencyInput) {
        double rate = 1.31;
        return currencyInput * rate;
    }
}