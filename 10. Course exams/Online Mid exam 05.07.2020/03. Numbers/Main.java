import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAsText = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();

        int sum = 0;
        int currentNum = 0;
        boolean isFound = false;

        for (int i = 0; i < numbersAsText.length; i++) {
            int number = Integer.parseInt(numbersAsText[i]);
            numbers.add(number);
            sum += number;
            currentNum++;
        }

        double averageSum = sum * 1.0 / currentNum;

        Collections.sort(numbers);
        Collections.reverse(numbers);

        int count = 0;
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > averageSum) {
                isFound = true;
                System.out.print(numbers.get(i) + " ");
                count++;
                if (count == 5) {
                    break;
                }
            }
        }

        if (!isFound) {
            System.out.println("No");
        }
    }
}

