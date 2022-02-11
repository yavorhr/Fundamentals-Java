import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAsText = scanner.nextLine().split("\\s+");
        int[] numbers = new int[numbersAsText.length];

        for (int i = 0; i < numbersAsText.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsText[i]);
        }

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Switch":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < numbers.length) {
                        numbers[index] = numbers[index] * -1;
                    }
                    break;
                case "Change":
                    index = Integer.parseInt(tokens[1]);
                    int value = Integer.parseInt(tokens[2]);
                    if (index >= 0 && index < numbers.length) {
                        numbers[index] = value;
                    }
                    break;
                case "Sum":
                    String todo = tokens[1];
                    switch (todo) {
                        case "Negative":
                            int sumNegative = 0;
                            for (int i = 0; i < numbers.length; i++) {
                                if (numbers[i] < 0) {
                                    sumNegative += numbers[i];
                                }
                            }
                            System.out.println(sumNegative);
                            break;
                        case "Positive":
                            int sumPositive = 0;
                            for (int i = 0; i < numbers.length; i++) {
                                if (numbers[i] >= 0) {
                                    sumPositive += numbers[i];
                                }
                            }
                            System.out.println(sumPositive);
                            break;
                        case "All":
                            int sumAll = 0;
                            for (int i = 0; i < numbers.length; i++) {
                                sumAll += numbers[i];
                            }
                            System.out.println(sumAll);
                            break;
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] >= 0) {
                System.out.print(numbers[i] + " ");
            }
        }

    }
}
































