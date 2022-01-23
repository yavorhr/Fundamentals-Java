import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAsText = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String num : numbersAsText) {
            int number = Integer.parseInt(num);
            if (number >= 0) {
                numbers.add(number);
            }
        }

        Collections.reverse(numbers);
        if (numbers.isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println(numbers.toString().replaceAll("[\\[\\],]",""));
        }
    }
}





