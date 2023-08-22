import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        BigDecimal sum = sumNumbers(n, scanner);

        System.out.println(sum);
    }

    private static BigDecimal sumNumbers(int n, Scanner scanner) {
        BigDecimal sum = new BigDecimal(0);

        for (int i = 0; i < n; i++) {
            BigDecimal numberInput = new BigDecimal(scanner.nextLine());
            sum = sum.add(numberInput);
        }

        return sum;
    }
}