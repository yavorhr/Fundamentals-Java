import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = readIntFromConsole(scanner);
        int digit = readIntFromConsole(scanner);

        int count = countBinaryNumber(decimalNumber, digit);
        printResult(count);
    }

    private static void printResult(int count) {
        System.out.println(count);
    }

    private static int readIntFromConsole(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }


    private static int countBinaryNumber(int decimalNumber, int digit) {
        int count = 0;

        while (decimalNumber != 0) {
            int reminder = decimalNumber % 2;
            if (reminder == digit) {
                count++;
            }
            decimalNumber /= 2;
        }
        return count;
    }
}


