import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double pounds = Double.parseDouble(scanner.nextLine());
        double exchangeRate = 1.31;

        System.out.printf("%.3f", pounds * exchangeRate);
    }
}

