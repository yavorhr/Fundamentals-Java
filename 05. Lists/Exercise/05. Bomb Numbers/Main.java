import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = readIntegersFromConsole(scanner);

        String[] commands = scanner.nextLine().split("\\s+");
        int bomb = parseStringToInt(0, commands);
        int power = parseStringToInt(1, commands);

        while (numbers.contains(bomb)) {
            int index = numbers.indexOf(bomb);
            detonateBombAndRemoveAdjacentNumbers(numbers, power, index);
        }
        printSum(numbers);
    }

    private static void printSum(List<Integer> numbers) {
        int result = 0;
        for (int number : numbers) {
            result += number;
        }
        System.out.println(result);
    }

    private static void detonateBombAndRemoveAdjacentNumbers(List<Integer> numbers, int power, int index) {
        int leftBound = Math.max(index - power, 0);
        int rightBound = Math.min(index + power, numbers.size() - 1);

        for (int i = rightBound; i >= leftBound; i--) {
            numbers.remove(i);
        }
    }

    private static List<Integer> readIntegersFromConsole(Scanner scanner) {
        return
                Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
    }

    private static int parseStringToInt(int i, String[] commands) {
        return Integer.parseInt(commands[i]);
    }
}


