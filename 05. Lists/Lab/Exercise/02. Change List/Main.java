import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAsText = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();

        for (String numberText : numbersAsText) {
            int number = Integer.parseInt(numberText);
            numbers.add(number);
        }

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            Integer element = Integer.valueOf(tokens[1]);
            switch (command) {
                case "Delete":
                    while (numbers.contains(element)) {
                        numbers.remove(element);
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, element);
                        break;
                    }
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}





