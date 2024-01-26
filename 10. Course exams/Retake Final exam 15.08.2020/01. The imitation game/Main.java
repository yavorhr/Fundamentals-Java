import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"Decode".equals(input)) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];

            switch (command) {
                case "Move" -> {
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    String substring = string.substring(0, numberOfLetters );
                    string = string
                            .replace(substring, "")
                            .concat(substring);
                }
                case "Insert" -> {
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];
                    string = new StringBuilder(string)
                            .insert(index, value)
                            .toString();

                }
                case "ChangeAll" -> {
                    String substring = tokens[1];
                    String replacement = tokens[2];
                    string = string.replaceAll(substring, replacement);
                }
            }
            input = scanner.nextLine();
        }

        System.out.printf("The decrypted message is: %s", string);
    }
}