import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAsText = scanner.nextLine().split(" ");
        int[] numbers = new int[numbersAsText.length];
        for (int i = 0; i < numbersAsText.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsText[i]);
        }

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "swap":
                    int indexOne = Integer.parseInt(tokens[1]);
                    int indexTwo = Integer.parseInt(tokens[2]);
                    int temp = numbers[indexTwo];
                    numbers[indexTwo] = numbers[indexOne];
                    numbers[indexOne] = temp;
                    break;
                case "multiply":
                    int multiplyOne = Integer.parseInt(tokens[1]);
                    int multiplyTwo = Integer.parseInt(tokens[2]);
                    int product = numbers[multiplyOne] * numbers[multiplyTwo];
                    numbers[multiplyOne] = product;
                    break;
                case "decrease":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] -= 1;
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        for (int i = 0; i < numbers.length-1; i++) {
            System.out.print (numbers[i] + ", ");
        }

        System.out.print(numbers[numbers.length-1]);
    }
}

