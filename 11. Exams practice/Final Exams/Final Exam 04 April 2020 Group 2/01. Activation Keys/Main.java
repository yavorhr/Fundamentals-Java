import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"Generate".equals(input)) {
            String[] tokens = input.split(">>>");
            String command = tokens[0];

            switch (command) {
                case "Contains" -> {
                    String substring = tokens[1];
                    if (activationKey.contains(substring)) {
                        System.out.printf("%s contains %s\n", activationKey, substring);
                    } else {
                        printCurrentOutput("Substring not found!");
                    }
                }
                case "Flip" -> {
                    String criteria = tokens[1];
                    String substring = getSubstring(tokens[2], tokens[3], activationKey);

                    if (criteria.equals("Upper")) {
                        String substringToUpper = substring.toUpperCase();
                        activationKey = activationKey.replace(substring, substringToUpper);
                    } else {
                        String substringToLower = substring.toLowerCase();
                        activationKey = activationKey.replace(substring, substringToLower);
                    }

                    printCurrentOutput(activationKey);
                }
                case "Slice" -> {
                    String substring = getSubstring(tokens[1], tokens[2], activationKey);
                    activationKey = activationKey.replace(substring, "");

                    printCurrentOutput(activationKey);
                }
            }
            input = scanner.nextLine();
        }

        System.out.printf("Your activation key is: %s", activationKey);
    }

    private static void printCurrentOutput(String activationKey) {
        System.out.println(activationKey);
    }

    private static String getSubstring(String firstIndex, String secondIndex, String activationKey) {
        int startIndex = Integer.parseInt(firstIndex);
        int endIndex = Integer.parseInt(secondIndex);

        return activationKey.substring(startIndex, endIndex);
    }
}




