import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersAsText = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();

        for (String numberAsText : numbersAsText) {
            int currentNum = Integer.parseInt(numberAsText);
            numbers.add(currentNum);
        }

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] token = input.split(" ");
            String command = token[0];

            switch (command) {
                case "Contains":
                    int number = Integer.parseInt(token[1]);
                    if (numbers.contains(number)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String evenOrOdd = token[1];
                    if (evenOrOdd.equals("even")) {
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 == 0) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                        break;
                    } else {
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) % 2 != 0) {
                                System.out.print(numbers.get(i) + " ");
                            }
                        }
                        System.out.println();
                        break;
                    }
                case "Get":
                    int sum = 0;
                    for (int i = 0; i < numbers.size(); i++) {
                        sum += numbers.get(i);
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String symbol = token[1];
                    int num = Integer.parseInt(token[2]);
                    if (symbol.equals("<")) {
                        for (int numberToCompare : numbers) {
                            if (numberToCompare < num) {
                                System.out.print(numberToCompare + " ");
                            }
                        }
                        System.out.println();
                    } else if (symbol.equals(">")) {
                        for (int numberToCompare : numbers) {
                            if (numberToCompare > num) {
                                System.out.print(numberToCompare + " ");
                            }
                        }
                        System.out.println();
                    } else if (symbol.equals(">=")) {
                        for (int numberToCompare : numbers) {
                            if (numberToCompare >= num) {
                                System.out.print(numberToCompare + " ");
                            }
                        }
                        System.out.println();
                    } else if (symbol.equals("<=")) {
                        for (int numberToCompare : numbers) {
                            if (numberToCompare <= num) {
                                System.out.print(numberToCompare + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;

            }
            input = scanner.nextLine();
        }

    }
}

