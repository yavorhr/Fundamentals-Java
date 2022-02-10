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
                case "Make":
                    String upperOrLower = tokens[1];
                    if (upperOrLower.equals("Upper")) {
                        email = email.toUpperCase();
                        System.out.println(email);
                    } else {
                        email = email.toLowerCase();
                        System.out.println(email);
                    }
                    break;
                case "GetDomain":
                    int count = Integer.parseInt(tokens[1]);
                    String domain = email.substring(email.length() - count);
                    System.out.println(domain);
                    break;
                case "GetUsername":
                    if (email.contains("@")) {
                        int end = email.indexOf('@');
                        String userName = email.substring(0, end);
                        System.out.println(userName);
                    } else {
                        System.out.println(String.format("The email %s doesn't contain the @ symbol.", email));
                    }
                    break;
                case "Replace":
                    String toReplace = tokens[1];
                    if (email.contains(toReplace)) {
                        email = email.replace(toReplace, "-");
                    }
                    System.out.println(email);
                    break;
                case "Encrypt":
                    for (int i = 0; i < email.length()-1; i++) {
                        char currChar = email.charAt(i);
                        System.out.print(+currChar + " ");
                    }
                    System.out.print(+email.charAt(email.length()-1));

                    break;
            }
            input = scanner.nextLine();
        }
    }
}





