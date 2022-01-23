import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAsText = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();

        for (String numberAsText : numbersAsText) {
            int currentNum = Integer.parseInt(numberAsText);
            numbers.add(currentNum);
        }

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] token = input.split(" ");
            String command = token[0];

            switch (command) {
                case "Add": {
                    int addNumber = Integer.parseInt(token[1]);
                    numbers.add(addNumber);
                    break;
                }
                case "Remove": {
                    int number = Integer.parseInt(token[1]);
                    numbers.remove(Integer.valueOf(number));
                    break;
                }
                case "RemoveAt": {
                    int index = Integer.parseInt(token[1]);
                    numbers.remove(index);
                    break;
                }
                case "Insert": {
                    int number = Integer.parseInt(token[1]);
                    int index = Integer.parseInt(token[2]);
                    numbers.add(index, number);
                    break;
                }
            }
            input = scanner.nextLine();
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }

    }
}

