import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"Done".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "TakeOdd" -> {
                    password = getCharsAtOddIndexes(password);
                    printMessage(password);
                }
                case "Cut" -> {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    int endIndex = startIndex + length;

                    String substring = password.substring(startIndex, endIndex);
                    password = password.replace(substring, "");

                    printMessage(password);
                }
                case "Substitute" -> {
                    String substring = tokens[1];
                    String substitute = tokens[2];

                    if (!password.contains(substring)) {
                        printMessage("Nothing to replace!");
                    } else {
                        password = password.replace(substring, substitute);

                        printMessage(password);
                    }
                }
            }
            input = scanner.nextLine();
        }
        printMessage("Your password is:", password);
    }

    private static void printMessage(String... values) {
        if (values.length == 1) {
            System.out.println(values[0]);
        } else {
            System.out.printf("%s %s", values[0], values[1]);
        }
    }

    private static String getCharsAtOddIndexes(String password) {
        StringBuilder newPassword = new StringBuilder();

        for (int i = 0; i < password.length(); i++) {
            if (i % 2 != 0) {
                newPassword.append(password.charAt(i));
            }
        }
        return newPassword.toString();
    }
}




