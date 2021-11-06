import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Math.abs(Integer.parseInt(scanner.nextLine()));
        System.out.println(multiply(number));
    }

    private static int multiply(int number) {
        return evenNumbersSum(number) * oddNumbersSum(number);
    }

    private static int evenNumbersSum(int number) {
        int evenSum = 0;

        while (number > 0) {
            int currentNumber = number % 10;
            if (currentNumber % 2 == 0) {
                evenSum += currentNumber;
            }
            number = number / 10;
        }
        return evenSum;
    }

    private static int oddNumbersSum(int number) {
        int oddSum = 0;

        while (number > 0) {
            int currentNumber = number % 10;
            if (!(currentNumber % 2 == 0)) {
                oddSum += currentNumber;
            }
            number = number / 10;
        }
        return oddSum;
    }
}
