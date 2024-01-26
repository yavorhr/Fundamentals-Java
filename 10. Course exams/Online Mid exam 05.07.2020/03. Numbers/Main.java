import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        double average = numbers.stream()
                .mapToInt(Integer::valueOf)
                .average()
                .orElse(0);

        numbers.stream()
                .filter(n -> n > average)
                .sorted((f, s) -> s - f)
                .limit(5)
                .forEach(n -> System.out.print(n + " "));
    }
}