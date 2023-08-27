import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = readListOfInts(scanner);

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            int number = Integer.parseInt(tokens[1]);

            switch (command) {
                case "Delete" -> {
                    deleteAllEqualElements(list, number);
                }
                case "Insert" -> {
                    int index = Integer.parseInt(tokens[2]);
                    addElementAtGivenIndex(list, number, index);
                }
            }
            input = scanner.nextLine();
        }
        printResult(list);
    }

    private static void addElementAtGivenIndex(List<Integer> list, int number, int index) {
        list.add(index, number);
    }

    private static void printResult(List<Integer> list) {
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }


    private static List<Integer> readListOfInts(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void deleteAllEqualElements(List<Integer> list, int number) {
        while (list.contains(number)) {
            list.remove(Integer.valueOf(number));
        }
    }
}