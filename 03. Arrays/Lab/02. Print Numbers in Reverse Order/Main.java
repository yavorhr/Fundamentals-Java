import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = initArray(scanner);
        printArrayReversed(numbersArray);
    }

    private static int[] initArray(Scanner scanner) {
        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int inputInt = Integer.parseInt(scanner.nextLine());
            numbers[i] = inputInt;
        }
        return numbers;
    }

    private static void printArrayReversed(int[] numbersArray) {
        for (int i = numbersArray.length - 1; i >= 0; i--) {
            System.out.print(numbersArray[i] + " ");
        }
    }
}