import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String input = scanner.nextLine();
        while (!"Finish".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Replace" -> {
                    char oldChar = tokens[1].charAt(0);
                    char newChar = tokens[2].charAt(0);

                    string = string.replace(oldChar, newChar);
                    printCurrentString(string);
                }
                case "Cut" -> {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (indexIsValid(startIndex, string) && indexIsValid(endIndex, string)) {
                        String substring = getSubstring(string, startIndex, endIndex);
                        string = string.replace(substring, "");

                        printCurrentString(string);
                    } else {
                        System.out.println("Invalid indexes!");
                    }
                }
                case "Make" -> {
                    String criteria = tokens[1];

                    if (criteria.equals("Lower")) {
                        string = string.toLowerCase();
                    } else if (criteria.equals("Upper")) {
                        string = string.toUpperCase();
                    }
                    printCurrentString(string);
                }
                case "Check" -> {
                    String charSequence = tokens[1];
                    if (string.contains(charSequence)) {
                        printMessage("Message contains ", charSequence);
                    } else {
                        printMessage("Message doesn't contain ", charSequence);
                    }
                }
                case "Sum" -> {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (indexIsValid(startIndex, string) && indexIsValid(endIndex, string)) {
                        String substring = getSubstring(string, startIndex, endIndex);

                        int sum = getSum(substring);

                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid indexes!");
                    }
                }
            }
            input = scanner.nextLine();
        }
    }

    private static int getSum(String substring) {
        int sum = 0;
        for (char character : substring.toCharArray()) {
            sum += character;
        }
        return sum;
    }

    private static void printCurrentString(String string) {
        System.out.println(string);
    }

    private static String getSubstring(String string, int startIndex, int endIndex) {
        return string.substring(startIndex, endIndex + 1);
    }

    private static void printMessage(String message, String charSequence) {
        System.out.println(message + charSequence);
    }

    private static boolean indexIsValid(int index, String string) {
        return index > 0 && index < string.length();
    }
}

