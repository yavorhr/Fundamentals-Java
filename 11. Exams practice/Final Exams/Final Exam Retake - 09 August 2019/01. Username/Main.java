import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"Sign up".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Case" -> {
                    String condition = tokens[1];
                    username = convertInput(condition, username);
                    printOutput(username);
                }
                case "Reverse" -> {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (indexIsValid(startIndex, username) && indexIsValid(endIndex, username)) {
                        String reversed = getReversed(username, startIndex, endIndex);
                        printOutput(reversed);
                    }
                }
                case "Cut" -> {
                    String substring = tokens[1];
                    if (username.contains(substring)) {
                        username = username.replace(substring, "");
                        printOutput(username);
                    } else {
                        printOutput(String.format("The word %s doesn't contain %s.", username, substring));
                    }
                }
                case "Replace" -> {
                    String charToReplace = tokens[1];
                    username = replaceChars(charToReplace, username);
                    printOutput(username);
                }
                case "Check" -> {
                    String currentChar = tokens[1];
                    if (username.contains(currentChar)) {
                        printOutput("Valid");
                    } else {
                        printOutput(String.format("Your username must contain %s.", currentChar));
                    }
                }
            }
            input = scanner.nextLine();
        }
    }

    private static String getReversed(String username, int startIndex, int endIndex) {
        return new StringBuilder(username.substring(startIndex, endIndex + 1))
                .reverse()
                .toString();
    }

    private static void printOutput(String string) {
        System.out.println(string);
    }

    private static String replaceChars(String charToReplace, String input) {
        int charIndex = input.indexOf(charToReplace);

        while (charIndex != -1) {
            input = input.replace(charToReplace, "*");

            charIndex = input.indexOf(charToReplace);
        }
        return input;
    }

    private static boolean indexIsValid(int index, String input) {
        return index >= 0 && index < input.length();
    }

    private static String convertInput(String condition, String input) {
        if (condition.equals("lower")) {
            input = input.toLowerCase();
        } else if (condition.equals("upper")) {
            input = input.toUpperCase();
        }
        return input;
    }
}




