import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "!(?<command>[A-Z][a-z]{2,})!:\\[(?<message>[A-Za-z]{8,})\\]";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String command = matcher.group("command");
                String message = matcher.group("message");
                System.out.printf("%s: ",command);

                for (int j = 0; j < message.length(); j++) {
                    char currentChar = message.charAt(j);
                    if (Character.isLetter(currentChar)){
                        System.out.print((int) currentChar + " ");
                    }
                }
                System.out.println();
            } else {
                System.out.println("The message is invalid");
            }
        }

    }
}





