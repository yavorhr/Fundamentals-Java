import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = readArrayList(scanner);

        int index = 0;
        while (index < numbers.size() - 1) {
            double currentNumber = getNumberByIndex(numbers, index);
            double nextNumber = getNumberByIndex(numbers, index + 1);

            if (currentNumber == nextNumber) {
                sumEqualNumbers(numbers, index, currentNumber, nextNumber);
                index = 0;
            } else {
                index++;
            }
        }
        printResult(numbers);
    }

    private static void sumEqualNumbers(List<Double> numbers, int index, double currentNumber, double nextNumber) {
        double sum = currentNumber + nextNumber;
        numbers.set(index, sum);
        numbers.remove(index + 1);
    }

    private static double getNumberByIndex(List<Double> numbers, int index) {
        return numbers.get(index);
    }

    private static List<Double> readArrayList(Scanner scanner) {
        return
                Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .map(Double::parseDouble)
                        .collect(Collectors.toList());
    }

    private static void printResult(List<Double> arrayList) {
        for (double number : arrayList) {
            System.out.printf("%.0f ", number);
        }
    }

}
