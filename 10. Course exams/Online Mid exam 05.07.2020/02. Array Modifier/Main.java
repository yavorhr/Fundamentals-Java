import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static int EMPLOYEES_COUNT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "swap" -> {
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);

                    swapIndexes(numbers, index1, index2);
                }
                case "multiply" -> {
                    int index1 = Integer.parseInt(tokens[1]);
                    int index2 = Integer.parseInt(tokens[2]);

                    numbers[index1] = numbers[index1] * numbers[index2];
                }
                case "decrease" -> numbers = Arrays.stream(numbers).map(e -> e -= 1).toArray();
            }

            input = scanner.nextLine();
        }
        printOutput(numbers);
    }

    private static void printOutput(int[] numbers) {
        String result = Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(result);
    }

    private static void swapIndexes(int[] numbers, int index1, int index2) {
        int temp = numbers[index1];
        numbers[index1] = numbers[index2];
        numbers[index2] = temp;
    }
}




