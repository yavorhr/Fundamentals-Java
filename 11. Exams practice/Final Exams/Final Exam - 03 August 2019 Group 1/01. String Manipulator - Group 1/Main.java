import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");

            String command = tokens[0];
            switch (command) {
                case "Translate" -> {
                    String character = tokens[1];
                    String replacement = tokens[2];

                    if (stringContainsSubs(string, character)) {
                        string = string.replace(character, replacement);
                    }

                    printResult(string);
                }
                case "Includes" -> {
                    String substring = tokens[1];

                    if (stringContainsSubs(string, substring)) {
                        printResult("True");
                    } else {
                        printResult("False");
                    }
                }
                case "Start" -> {
                    String substring = tokens[1];

                    if (string.startsWith(substring)) {
                        printResult("True");
                    } else {
                        printResult("False");
                    }
                }
                case "Lowercase" -> {
                    string = string.toLowerCase();
                    printResult(string);
                }
                case "FindIndex" -> {
                    String character = tokens[1];
                    int index = string.lastIndexOf(character);

                    if (index != -1) {
                        System.out.println(index);
                    }
                }
                case "Remove" -> {
                    int length = Integer.parseInt(tokens[2]);

                    if (lengthIsValid(length, string.length())) {
                        string = string.substring(length);
                        printResult(string);
                    }
                }
            }

            input = scanner.nextLine();
        }
    }

    private static boolean lengthIsValid(int length, int stringLength) {
        return length >= 0 && length <= stringLength;
    }

    private static boolean stringContainsSubs(String string, String substring) {
        return string.contains(substring);
    }

    private static void printResult(String string) {
        System.out.println(string);
    }
}


