import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userName = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"Sign up".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Case":
                    String lowerOrUpper = tokens[1];
                    if (lowerOrUpper.equals("lower")) {
                        userName = userName.toLowerCase();
                        System.out.println(userName);
                    } else {
                        userName = userName.toUpperCase();
                        System.out.println(userName);
                    }
                    break;
                case "Reverse":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && endIndex < userName.length()) {
                        String reversed = userName.substring(startIndex, endIndex + 1);
                        StringBuilder sb = new StringBuilder(reversed).reverse();
                        System.out.println(sb.toString());
                    }
                    break;
                case "Cut":
                    String substring = tokens[1];
                    if (userName.contains(substring)) {
                        userName = userName.replace(substring, "");
                        System.out.println(userName);
                    } else {
                        System.out.println(String.format("The word %s doesn't contain %s.", userName, substring));
                    }
                    break;
                case "Replace":
                    String currChar = tokens[1];
                    if (userName.contains(currChar)) {
                        userName = userName.replace(currChar, "*");
                        System.out.println(userName);
                    }
                    break;
                case "Check":
                    String keyChar = tokens[1];
                    if (userName.contains(keyChar)) {
                        System.out.println("Valid");
                    } else {
                        System.out.println(String.format("Your username must contain %s.", keyChar));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}






