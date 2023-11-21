import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        String[] filteredUsernames =
                Arrays.stream(usernames)
                        .filter(Main::filterValidUsernames)
                        .toArray(String[]::new);

        printResult(filteredUsernames);
    }

    private static void printResult(String[] filteredUsernames) {
        if (filteredUsernames.length > 0) {
            System.out.println(String.join("\n", filteredUsernames));
        }
    }

    private static boolean filterValidUsernames(String username) {
        boolean checkLength = validLength(username);
        boolean checkCharacters = validCharacters(username);

        return checkLength && checkCharacters;
    }

    private static boolean validCharacters(String username) {
        for (int i = 0; i < username.length(); i++) {
            char currentChar = username.charAt(i);

            if (!Character.isDigit(currentChar) && !Character.isLetter(currentChar) && currentChar != '-' && currentChar != '_') {
                return false;
            }
        }
        return true;
    }

    private static boolean validLength(String username) {
        return username.length() >= 3 && username.length() <= 16;
    }


}