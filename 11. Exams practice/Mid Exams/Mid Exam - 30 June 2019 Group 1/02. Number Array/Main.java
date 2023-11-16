import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Switch" -> {
                    int index = Integer.parseInt(tokens[1]);

                    if (isIndexValid(numbers,index)) {
                        numbers[index] *= -1;
                    }
                }
                case "Change" -> {
                    int index = Integer.parseInt(tokens[1]);
                    int value = Integer.parseInt(tokens[2]);

                    if (isIndexValid(numbers,index)) {
                        numbers[index] = value;
                    }
                }
                case "Sum" -> {
                    String condition = tokens[1];
                    sumNumbersByCondition(numbers, condition);
                }
            }
            input = scanner.nextLine();
        }

        printResult(numbers);
    }

    private static void printResult(int[] numbers) {
        Arrays.stream(numbers).filter(n -> n >= 0).forEach(n -> System.out.print(n + " "));
    }

    private static void sumNumbersByCondition(int[] numbers, String condition) {
        switch (condition) {
            case "Negative" -> System.out.println(Arrays.stream(numbers).filter(n -> n < 0).sum());
            case "Positive" -> System.out.println(Arrays.stream(numbers).filter(n -> n > 0).sum());
            case "All" -> System.out.println(Arrays.stream(numbers).sum());
        }
    }

    private static boolean isIndexValid(int[] array, int index) {
        return index >= 0 && index < array.length;
    }
}




