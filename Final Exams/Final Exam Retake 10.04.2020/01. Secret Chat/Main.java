
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initialMessage = scanner.nextLine();
        StringBuilder result = new StringBuilder(initialMessage);

        String input = scanner.nextLine();
        while (!"Reveal".equals(input)) {

            String[] tokens = input.split(":\\|:");
            String command = tokens[0];
            switch (command) {
                case "InsertSpace": {
                    int index = Integer.parseInt(tokens[1]);
                    result.insert(index, " ");
                    break;

                }
                case "Reverse": {
                    String search = tokens[1];
                    int index = result.indexOf(search);

                    if (index >= 0) {
                        result.delete(index, index + search.length());
                        String reversed = new StringBuilder(search).reverse().toString();
                        result.append(reversed);
                    } else {
                        System.out.println("error");
                        input = scanner.nextLine();
                        continue;
                    }
                }

                break;
                case "ChangeAll":
                    String find = tokens[1];
                    String replace = tokens[2];

                    String replaced = result.toString().replace(find, replace);
                    result = new StringBuilder(replaced);
                    break;
            }

            System.out.println(result);
            input = scanner.nextLine();
        }

        System.out.println(String.format("You have a new text message: %s", result));
    }
}

