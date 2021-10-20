import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";
        int counter = 0;

        for (int i = username.length() - 1; i >= 0; i--) {
            char output = username.charAt(i);
            password += output;
        }

        for (int i = 0; i < 4; i++) {
            String currentPassword = scanner.nextLine();
            if (password.equals(currentPassword)) {
                System.out.printf("User %s logged in.", username);
                break;
            } else {
                counter++;
                System.out.println("Incorrect password. Try again.");
            }

            if (counter == 3) {
                System.out.printf("User %s blocked!", username);
                break;
            }
        }

    }
}
