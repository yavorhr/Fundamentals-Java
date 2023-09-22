import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] syllables = scanner.nextLine().split("\\|");

        String input = scanner.nextLine();
        while (!"Done".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Move" -> {
                    String direction = tokens[1];
                    int index = Integer.parseInt(tokens[2]);

                    if (direction.equals("Left")) {
                        boolean moveIsPossible = checkMoveLeft(syllables, index);

                        if (moveIsPossible) {
                            switchWithLeftElement(syllables, index);
                        }
                    } else if (direction.equals("Right")) {
                        boolean moveIsPossible = checkMoveRight(syllables, index);

                        if (moveIsPossible) {
                            switchWithRightElement(syllables, index);
                        }
                    }
                }
                case "Check" -> {
                    String evenOrOdd = tokens[1];
                    if (evenOrOdd.equals("Even")) {
                        printElementsOnEvenIndex(syllables);
                    } else if (evenOrOdd.equals("Odd")) {
                        printElementsOnOddIndex(syllables);
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("You crafted %s!", String.join("", syllables));
    }

    private static void printElementsOnOddIndex(String[] syllables) {
        IntStream.range(0, syllables.length)
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> syllables[i])
                .forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static void printElementsOnEvenIndex(String[] syllables) {
        IntStream.range(0, syllables.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> syllables[i])
                .forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static boolean checkMoveRight(String[] array, int index) {
        if (index >= 0 && index < array.length - 1) {
            return true;
        }
        return false;
    }

    private static boolean checkMoveLeft(String[] array, int index) {
        if (index > 0 && index <= array.length - 1) {
            return true;
        }
        return false;
    }

    private static void switchWithRightElement(String[] array, int index) {
        String temp = array[index];
        array[index] = array[index + 1];
        array[index + 1] = temp;
    }

    private static void switchWithLeftElement(String[] array, int index) {
        String temp = array[index];
        array[index] = array[index - 1];
        array[index - 1] = temp;
    }


}



