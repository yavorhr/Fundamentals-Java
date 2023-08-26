import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = readList(scanner);

        numbersList = filterListOfIntegers(numbersList);

        Collections.reverse(numbersList);

        printResult(numbersList);
    }

    private static List<Integer> readList(Scanner scanner) {
        return Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static List<Integer> filterListOfIntegers(List<Integer> list) {
        return list.stream().filter(e -> e > 0).collect(Collectors.toList());
    }

    private static void printResult(List<Integer> list) {
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}
