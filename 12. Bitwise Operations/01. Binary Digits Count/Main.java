import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int decimalNumber = readIntFromConsole(scanner);
        int digit = readIntFromConsole(scanner);

        List<Integer> binarySequence = new ArrayList<>();
        addBinaryValuesToList(binarySequence, decimalNumber);

        long count = countBinaryDigit(binarySequence, digit);
        System.out.println(count);
    }

    private static int readIntFromConsole(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static long countBinaryDigit(List<Integer> binarySequence, int digit) {
        return binarySequence.stream().filter(n -> n == digit).count();
    }

    private static void addBinaryValuesToList(List<Integer> binarySequence, int decimalNumber) {
        while (decimalNumber != 0) {
            int reminder = decimalNumber % 2;
            binarySequence.add(reminder);
            decimalNumber /= 2;
        }
    }
}


