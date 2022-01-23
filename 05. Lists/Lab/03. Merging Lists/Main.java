import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" ");
        String[] secondInput = scanner.nextLine().split(" ");

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        for (String elementFirstInput : firstInput) {
            int number = Integer.parseInt(elementFirstInput);
            first.add(number);
        }

        for (String elementSecondInput : secondInput) {
            int number = Integer.parseInt(elementSecondInput);
            second.add(number);
        }

        int minLength = Math.min(first.size(), second.size());

        for (int i = 0; i < minLength; i++) {
            System.out.print(first.get(i) + " ");
            System.out.print(second.get(i) + " ");
        }

        for (int i = minLength; i < first.size(); i++) {
            System.out.print(first.get(i) + " ");
        }
        for (int i = minLength; i < second.size(); i++) {
            System.out.print(second.get(i) + " ");
        }
    }
}

