import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        String[] strings = scanner.nextLine().split(" ");
        for (String string : strings) {
            int number = Integer.parseInt(string);
            numbers.add(number);
        }

        List<Integer> modify = new ArrayList<>();

        for (int i = 0; i < numbers.size() / 2; i++) {
            int sum = numbers.get(i) + numbers.get(numbers.size()-1-i);
            modify.add(sum);
        }

        if (numbers.size() % 2 != 0) {
            int middleIndex = numbers.size() / 2;
            modify.add(numbers.get(middleIndex));
        }

        numbers = modify;

        for (int number : modify) {
            System.out.print(number + " ");

        }
    }
}

/*

        String[] numbersInLine = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numbersInLine.length; i++) {
            int currentNumber = Integer.parseInt(numbersInLine[i]);
            numbers.add(currentNumber);
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (i == numbers.size() - 1) {
                break;
            }
            int firstElement = numbers.get(i);
            int lastElement = numbers.get(numbers.size() - 1);
            int sum = firstElement + lastElement;
            numbers.set(i, sum);
            numbers.remove(numbers.size() - 1);
        }

        for (int i = 0; i < numbers.size(); i++) {
            System.out.print(numbers.get(i) + " ");
        }
    }
}

 */