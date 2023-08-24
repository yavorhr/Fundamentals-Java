import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputNumbers = readIntArray(scanner);

        int evenSum = Arrays.stream(inputNumbers).filter(e -> e % 2 == 0).sum();
        int oddSum = Arrays.stream(inputNumbers).filter(e -> e % 2 != 0).sum();

        System.out.println(evenSum - oddSum);
    }

    private static int[] readIntArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
