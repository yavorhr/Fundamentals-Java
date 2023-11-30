import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        StringBuilder result = new StringBuilder(message);

        String input = scanner.nextLine();
        while (!"Reveal".equals(input)) {
            String[] tokens = input.split(":\\|:");
            String command = tokens[0];

            switch (command) {
                case "InsertSpace" -> {
                    int index = Integer.parseInt(tokens[1]);
                    if (indexIsValid(index, result.length())) {
                        result.insert(index, " ");
                    }
                    printCurrentResult(result);
                }
                case "Reverse" -> {
                    String substring = tokens[1];
                    if (resultContainsStr(result, substring)) {
                        String newString = replaceOccurrences(result, substring, "");

                        String reversedSubstring = reverseSubstring(substring);
                        result = new StringBuilder(newString).append(reversedSubstring);

                        printCurrentResult(result);
                    } else {
                        System.out.println("error");
                    }
                }
                case "ChangeAll" -> {
                    String substring = tokens[1];
                    String replacement = tokens[2];

                    if (resultContainsStr(result, substring)) {
                        String newString = replaceOccurrences(result, substring, replacement);
                        result = new StringBuilder(newString);
                    }
                    printCurrentResult(result);
                }

            }
            input = scanner.nextLine();
        }

        printFinalResult(result);
    }

    private static void printFinalResult(StringBuilder result) {
        System.out.printf("You have a new text message: %s", result);
    }

    private static String replaceOccurrences(StringBuilder result, String substring, String replacement) {
        return result.toString().replace(substring, replacement);
    }

    private static boolean resultContainsStr(StringBuilder result, String substring) {
        return result.toString().contains(substring);
    }

    private static void printCurrentResult(StringBuilder result) {
        System.out.println(result);
    }

    private static String reverseSubstring(String substring) {
        StringBuilder sb = new StringBuilder();
        for (int i = substring.length() - 1; i >= 0; i--) {
            sb.append(substring.charAt(i));
        }
        return sb.toString();
    }

    private static boolean indexIsValid(int index, int length) {
        return index >= 0 && index < length;
    }
}


