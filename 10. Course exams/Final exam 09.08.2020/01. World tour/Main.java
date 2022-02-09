import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initialString = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"Travel".equals(input)) {
            String[] tokens = input.split(":");
            String command = tokens[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String stringAdd = tokens[2];
                    StringBuilder sb = new StringBuilder(initialString);

                    if (index >= 0 && index < initialString.length()) {
                        sb.insert(index, stringAdd);
                    }
                    initialString = sb.toString();
                    System.out.println(initialString);
                    break;

                case "Remove Stop":
                    int start = Integer.parseInt(tokens[1]);
                    int end = Integer.parseInt(tokens[2]);

                    if (start >= 0 && end < initialString.length()) {
                        String substring = initialString.substring(start, end + 1);
                        initialString = initialString.replace(substring, "");
                    }
                    System.out.println(initialString);
                    break;

                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    if (initialString.contains(oldString)) {
                        initialString = initialString.replace(oldString, newString);
                    }
                    System.out.println(initialString);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.format("Ready for world tour! Planned stops: %s", initialString));
    }
}


