import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String email = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"Complete".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Make" -> {
                    String criteria = tokens[1];
                    if (criteria.equals("Upper")) {
                        email = email.toUpperCase();
                        printEmail(email);
                    } else if (criteria.equals("Lower")) {
                        email = email.toLowerCase();
                        printEmail(email);
                    }
                }
                case "GetDomain" -> {
                    int count = Integer.parseInt(tokens[1]);
                    int startIndex = email.length() - count;
                    String subString = email.substring(startIndex);

                    printEmail(subString);
                }
                case "GetUsername" -> {
                    int endIndex = email.indexOf("@");

                    if (endIndex == -1) {
                        System.out.printf("The email %s doesn't contain the @ symbol.\n", email);
                    } else {
                        String substring = email.substring(0, endIndex);
                        printEmail(substring);
                    }
                }
                case "Replace" -> {
                    char character = tokens[1].charAt(0);

                    if (email.contains(character + "")) {
                        email = email.replace(character, '-');
                        printEmail(email);
                    }
                }
                case "Encrypt" -> {
                    for (char symbol : email.toCharArray()) {
                        System.out.print(+symbol + " ");
                    }
                }
            }
            input = scanner.nextLine();
        }
    }

    private static void printEmail(String email) {
        System.out.println(email);
    }
}


