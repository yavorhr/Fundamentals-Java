import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] integers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "swap" -> {
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);

                    if (isIndexValid(firstIndex, integers) && isIndexValid(secondIndex, integers)) {
                        swapIndexes(firstIndex, secondIndex, integers);
                    }
                }
                case "multiply" -> {
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);

                    if (isIndexValid(firstIndex, integers) && isIndexValid(secondIndex, integers)) {
                        multiplyIndexes(firstIndex, secondIndex, integers);
                    }
                }
                case "decrease" -> integers = Arrays.stream(integers).map(i -> i -= 1).toArray();
            }
            input = scanner.nextLine();
        }

        printResult(integers);
    }

    private static void printResult(int[] integers) {
        for (int i = 0; i < integers.length - 1; i++) {
            System.out.print(integers[i] + ", ");
        }
        System.out.print(integers[integers.length-1]);
    }

    private static void multiplyIndexes(int firstIndex, int secondIndex, int[] integers) {
        int result = integers[firstIndex] * integers[secondIndex];
        integers[firstIndex] = result;
    }

    private static void swapIndexes(int firstIndex, int secondIndex, int[] integers) {
        int temp = integers[firstIndex];
        integers[firstIndex] = integers[secondIndex];
        integers[secondIndex] = temp;
    }

    private static boolean isIndexValid(int firstIndex, int[] integers) {
        return firstIndex >= 0 && firstIndex < integers.length;
    }
}


