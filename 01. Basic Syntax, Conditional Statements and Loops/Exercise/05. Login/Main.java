import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String usernameInput = scanner.nextLine();
        String passwordInput = scanner.nextLine();

        String validPassword = reverseString(usernameInput);

        int countsLogin = 0;
        while (!passwordInput.equals(validPassword)) {
            countsLogin++;

            if (countsLogin == 4) {
                System.out.printf("User %s blocked!", usernameInput);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            passwordInput = scanner.nextLine();
        }

        if (passwordInput.equals(validPassword)) {
            System.out.printf("User %s logged in.", usernameInput);
        }
    }


    private static String reverseString(String usernameInput) {
        return new StringBuilder(usernameInput).reverse() + "";
    }

    private static StringBuilder reverseStringWithLoop(String username) {
        StringBuilder stringReversed = new StringBuilder();

        for (int i = username.length() - 1; i >= 0; i--) {
            char currentChar = username.charAt(i);
            stringReversed.append(currentChar);
        }
        return stringReversed;

    }
}