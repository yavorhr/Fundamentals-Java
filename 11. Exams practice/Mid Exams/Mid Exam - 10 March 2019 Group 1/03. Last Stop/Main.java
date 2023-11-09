import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = getList(scanner);
        String input = scanner.nextLine();

        while (!"END".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Insert" -> {
                    int index = Integer.parseInt(tokens[1]);
                    int paintingNumber = Integer.parseInt(tokens[2]);

                    if (indexIsValid(index, numbers)) {
                        numbers.add(index + 1, paintingNumber);
                    }
                }

                case "Switch" -> {
                    int firstNumber = Integer.parseInt(tokens[1]);
                    int secondNumber = Integer.parseInt(tokens[2]);

                    if (ifListContainsNumber(numbers, firstNumber) && ifListContainsNumber(numbers, secondNumber)) {
                        int firstNumberIndex = getIndex(numbers, firstNumber);
                        int secondNumberIndex = getIndex(numbers, secondNumber);

                        numbers.set(firstNumberIndex, secondNumber);
                        numbers.set(secondNumberIndex, firstNumber);
                    }
                }
                case "Hide" -> {
                    int paintingNumber = Integer.parseInt(tokens[1]);
                    int index = getIndex(numbers, paintingNumber);

                    if (ifListContainsNumber(numbers, paintingNumber)) {
                        numbers.remove(index);
                    }
                }
                case "Reverse" -> {
                    Collections.reverse(numbers);
                }
                case "Change" -> {
                    int paintingNumber = Integer.parseInt(tokens[1]);
                    int changedNumber = Integer.parseInt(tokens[2]);

                    if (ifListContainsNumber(numbers, paintingNumber)) {
                        int indexNumber = getIndex(numbers, paintingNumber);
                        numbers.set(indexNumber, changedNumber);
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.println(numbers);
    }

    private static int getIndex(List<Integer> numbers, int firstNumber) {
        return numbers.indexOf(firstNumber);
    }

    private static List<Integer> getList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static boolean ifListContainsNumber(List<Integer> numbers, int number) {
        return numbers.contains(number);
    }

    private static boolean indexIsValid(int index, List<Integer> numbers) {
        return index >= 0 && index < numbers.size();
    }
}




