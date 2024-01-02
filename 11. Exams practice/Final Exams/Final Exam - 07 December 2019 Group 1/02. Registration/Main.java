import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        int successfulLogins = 0;

        String regex = "(?<usernameSurrounding>U\\$)(?<username>[A-Z][a-z]{2,})\\1(?<passwordSurrounding>P@\\$)(?<password>[A-z]{5,})\\d+\\3";
        Pattern pattern = Pattern.compile(regex);

        while (n > 0) {
            String email = scanner.nextLine();
            Matcher matcher = pattern.matcher(email);

            if (matcher.find()) {
                String username = matcher.group("username");
                String password = matcher.group("password");

                successfulLogins++;

                printLoginCridentials(username, password);
            } else {
                printErrorMessage();
            }
            n--;
        }
        printLoginsCount(successfulLogins);
    }

    private static void printLoginsCount(int successfulLogins) {
        System.out.printf("Successful registrations: %d\n", successfulLogins);
    }

    private static void printErrorMessage() {
        System.out.println("Invalid username or password");
    }

    private static void printLoginCridentials(String username, String password) {
        System.out.printf(
                "Registration was successful\n" +
                        "Username: %s, Password: %s\n", username, password);
    }
}


