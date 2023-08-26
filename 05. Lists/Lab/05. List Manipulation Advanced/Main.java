import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = readListIntegers(scanner);

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Contains" -> {
                    int number = Integer.parseInt(tokens[1]);
                    printIfListContainsNum(number, list);
                }
                case "Print" -> {
                    String evenOrOdd = tokens[1];
                    printOddOrEvenList(evenOrOdd, list);
                }
                case "Get" -> {
                    System.out.println(getSum(list));
                }
                case "Filter" -> {
                    String operator = tokens[1];
                    int filterByNumber = Integer.parseInt(tokens[2]);
                    printFilteredList(operator, filterByNumber, list);
                }
            }
            input = scanner.nextLine();
        }
    }

    private static void printFilteredList(String operator, int filterByNumber, List<Integer> list) {
        switch (operator) {
            case ">=" -> {
                printGreaterThanOrEqual(filterByNumber, list);
            }
            case ">" -> {
                printGreaterThan(filterByNumber, list);
            }
            case "<=" -> {
                printSmallerOrEqual(filterByNumber, list);
            }
            case "<" -> {
                printSmallerThan(filterByNumber, list);
            }
        }
    }

    private static void printSmallerThan(int filterByNumber, List<Integer> list) {
        list.stream().filter(e -> e < filterByNumber).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static void printSmallerOrEqual(int filterByNumber, List<Integer> list) {
        list.stream().filter(e -> e <= filterByNumber).forEach(e -> System.out.print(e + " "));

        System.out.println();
    }

    private static void printGreaterThan(int filterByNumber, List<Integer> list) {
        list.stream().filter(e -> e > filterByNumber).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static void printGreaterThanOrEqual(int filterByNumber, List<Integer> list) {
        list.stream().filter(e -> e >= filterByNumber).forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static int getSum(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    private static void printOddOrEvenList(String evenOrOdd, List<Integer> list) {
        if (evenOrOdd.equals("odd")) {
            list.stream().filter(i -> i % 2 != 0).forEach(e -> System.out.print(e + " "));
        } else {
            list.stream().filter(i -> i % 2 == 0).forEach(e -> System.out.print(e + " "));
        }
        System.out.println();
    }

    private static void printIfListContainsNum(int number, List<Integer> list) {
        if (list.contains(number)) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }

    private static List<Integer> readListIntegers(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
