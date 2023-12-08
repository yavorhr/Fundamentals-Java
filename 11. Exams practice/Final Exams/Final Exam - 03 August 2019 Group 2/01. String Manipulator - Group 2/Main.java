import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String input = scanner.nextLine();
        while (!input.equals("Done")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Change" -> {
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    if (doesStringExist(message, substring)) {
                        message = message.replace(substring, replacement);
                        System.out.println(message);
                    }
                }
                case "Includes" -> {
                    String substring = tokens[1];
                    if (doesStringExist(message, substring)) {
                        printCurrentString("True");
                    } else {
                        printCurrentString("False");
                    }
                }
                case "End" -> {
                    String substring = tokens[1];
                    if (message.endsWith(substring)) {
                        printCurrentString("True");
                    } else {
                        printCurrentString("False");
                    }
                }
                case "Uppercase" -> {
                    message = message.toUpperCase();
                    printCurrentString(message);
                }
                case "FindIndex" -> {
                    String character = tokens[1];
                    if (doesStringExist(message, character)) {
                        System.out.println(message.indexOf(character));
                    }
                }
                case "Cut" -> {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);

                    String substring = getSubstring(message, startIndex, length);
                    printCurrentString(substring);
                }
            }
            input = scanner.nextLine();
        }
    }

    private static String getSubstring(String message, int startIndex, int length) {
        return message.substring(startIndex, startIndex + length);
    }

    private static void printCurrentString(String string) {
        System.out.println(string);
    }

    private static boolean doesStringExist(String message, String substring) {
        return message.contains(substring);
    }
}

