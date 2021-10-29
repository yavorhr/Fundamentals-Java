import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            int currentNumber = numbers[i];
            boolean topInteger = true;

            for (int j = i + 1; j < numbers.length; j++) {
                int firstToTheRight = numbers[j];
                if (currentNumber <= firstToTheRight) {
                    topInteger = false;
                    break;
                }
            }
            if (topInteger) {
                System.out.print(currentNumber + " ");
            }
        }

        System.out.print(input[input.length - 1]);
    }
}
