import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            StringBuilder reversed = new StringBuilder();

            reverseString(input, reversed);

            printResult(input, reversed);

            input = scanner.nextLine();
        }
    }

    private static void printResult(String input, StringBuilder reversed) {
        System.out.printf("%s = %s\n", input, reversed);
    }

    private static void reverseString(String input, StringBuilder reversed) {
        for (int i = input.length() - 1; i >= 0; i--) {
            reversed.append(input.charAt(i));
        }
    }
}