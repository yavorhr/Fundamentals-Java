import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initialString = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"Decode".equals(input)) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];
            switch (command) {
                case "Move":
                    int count = Integer.parseInt(tokens[1]);

                    String firstLetters = initialString.substring(0, count);
                    initialString = initialString.replace(firstLetters, "");
                    StringBuilder sb = new StringBuilder(initialString);
                    sb.append(firstLetters);
                    initialString = sb.toString();
                    break;
                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    StringBuilder newSb = new StringBuilder(initialString);
                    newSb.insert(index, value);
                    initialString = newSb.toString();
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    initialString = initialString.replace(substring, replacement);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(String.format("The decrypted message is: %s",initialString));
    }
}
