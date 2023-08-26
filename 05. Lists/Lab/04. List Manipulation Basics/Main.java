import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listIntegers = readListIntegers(scanner);

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            int number = Integer.parseInt(tokens[1]);

            switch (command) {
                case "Add" -> addNumber(listIntegers, number);
                case "Remove" -> removeNumber(listIntegers, number);
                case "RemoveAt" -> removeAtIndex(listIntegers, number);
                case "Insert" -> {
                    int index = Integer.parseInt(tokens[2]);
                    insertAtIndex(listIntegers, number, index);
                }
            }
            input = scanner.nextLine();
        }
        printModifiedList(listIntegers);
    }

    private static void insertAtIndex(List<Integer> listIntegers, int number, int index) {
        listIntegers.add(index, number);
    }

    private static void removeAtIndex(List<Integer> listIntegers, int number) {
        listIntegers.remove(number);
    }

    private static void removeNumber(List<Integer> listIntegers, int number) {
        listIntegers.remove(Integer.valueOf(number));
    }

    private static void addNumber(List<Integer> listIntegers, int number) {
        listIntegers.add(number);
    }

    private static void printModifiedList(List<Integer> listIntegers) {
        System.out.println(listIntegers.toString().replaceAll("[\\[\\],]", ""));
    }

    private static List<Integer> readListIntegers(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
