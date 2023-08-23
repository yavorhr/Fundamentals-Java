import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberInput = Integer.parseInt(scanner.nextLine());
        int sum = sumDigits(numberInput);

        System.out.println(sum);
    }

    private static int sumDigits(int numberInput) {
        int sumDigits = 0;
        while (numberInput > 0) {
            sumDigits += numberInput % 10;
            numberInput /= 10;
        }
        return sumDigits;
    }
}
