import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");

        int evenSum = 0;
        for (String number : numbers) {
            int currentNumber = Integer.parseInt(number);
            if (currentNumber % 2 == 0) {
                evenSum += currentNumber;
            }
        }

        System.out.println(evenSum);
    }
}
