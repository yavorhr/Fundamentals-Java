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

        numbers = numbers.stream()
                .filter(n -> n > average)
                .collect(Collectors.toList());

        Collections.reverse(numbers);

        numbers = numbers.stream()
                .limit(5)
                .sorted((a, b) -> b - a)
                .collect(Collectors.toList());

        printResult(numbers);
    }

    private static void printResult(List<Integer> numbers) {
        if (numbers.size() == 0) {
            System.out.println("No");
        } else {
         numbers.forEach(n -> System.out.print(n + " "));
        }
    }
}


