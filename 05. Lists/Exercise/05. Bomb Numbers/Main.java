import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersInLine = scanner.nextLine().split("\\s+");
        String[] commands = scanner.nextLine().split("\\s+");
        int bomb = Integer.parseInt(commands[0]);
        int power = Integer.parseInt(commands[1]);

        List<Integer> numbers = new ArrayList<>();

        for (String numberInLine : numbersInLine
        ) {
            int number = Integer.parseInt(numberInLine);
            numbers.add(number);
        }

        while (numbers.contains(bomb)) {
            int index = numbers.indexOf(bomb);
            int leftBound = Math.max(index - power, 0);
            int rightBound = Math.min(index + power, numbers.size() - 1);
            for (int i = rightBound; i >= leftBound; i--) {
                numbers.remove(i);
            }
        }

        int result = 0;
        for (int number : numbers
        ) {
            result += number;
        }

        System.out.println(result);

    }
}

