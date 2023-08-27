import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integerList = readIntegersList(scanner);

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Add" -> {
                    int number = parseStringToInt(tokens[1]);
                    integerList.add(number);
                }
                case "Remove" -> {
                    int index = parseStringToInt(tokens[1]);
                    if (outOfBounds(index, integerList)) {
                        System.out.println("Invalid index");
                        break;
                    }
                    integerList.remove(index);
                }
                case "Shift" -> {
                    String direction = tokens[1];
                    int count = parseStringToInt(tokens[2]);
                    shiftListToLeftOrRight(direction, integerList, count);
                }
                case "Insert" -> {
                    int number = parseStringToInt(tokens[1]);
                    int index = parseStringToInt(tokens[2]);
                    integerList.add(index, number);
                }
            }
            input = scanner.nextLine();
        }

        printResult(integerList);
    }

    private static boolean outOfBounds(int index, List<Integer> integerList) {
        return index < 0 || index > integerList.size() - 1;
    }

    private static void shiftListToLeftOrRight(String direction, List<Integer> integerList, int count) {
        if (direction.equals("left")) {
            for (int i = 0; i < count; i++) {
                int firstNumber = integerList.remove(0);
                integerList.add(firstNumber);
            }
        } else if (direction.equals("right")) {
            int lastNumber = integerList.remove(integerList.size() - 1);
            integerList.add(0, lastNumber);
        }
    }

    private static int parseStringToInt(String token) {
        return Integer.parseInt(token);
    }

    private static List<Integer> readIntegersList(Scanner scanner) {
        return
                Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
    }

    private static void printResult(List<Integer> integerList) {
        System.out.println(integerList.toString().replaceAll("[\\[\\],]", ""));
    }
}