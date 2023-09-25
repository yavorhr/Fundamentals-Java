import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(", ");

        String input = scanner.nextLine();
        while (!"Report".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Blacklist" -> {
                    String nameInput = tokens[1];
                    String currentName = getName(names, nameInput);

                    if (!currentName.equals("")) {
                        printResult(nameInput, "was blacklisted.");
                        int index = Arrays.asList(names).indexOf(nameInput);
                        names[index] = "Blacklisted";
                    } else {
                        printResult(nameInput, "was not found.");
                    }
                }
                case "Error" -> {
                    int index = Integer.parseInt(tokens[1]);
                    String nameInput = names[index];
                    String currentName = getName(names, nameInput);

                    if (!currentName.equals("Blacklisted") && !currentName.equals("Lost")) {
                        printResult(nameInput, "was lost due to an error.");
                        names[index] = "Lost";
                    }
                }
                case "Change" -> {
                    int index = Integer.parseInt(tokens[1]);
                    String newName = tokens[2];

                    if (indexIsValid(names, index)) {
                        System.out.printf("%s changed his username to %s.\n", names[index], newName);
                        names[index] = newName;
                    }
                }
            }
            input = scanner.nextLine();
        }
        printCollection(names);
    }

    private static long filterArray(String[] array, String criteria) {
        return Arrays.stream(array).filter(n -> n.equals(criteria)).count();
    }

    private static String getName(String[] names, String nameInput) {
        return Arrays.stream(names).filter(n -> n.equals(nameInput)).findFirst().orElse("");
    }

    private static boolean indexIsValid(String[] names, int index) {
        return index >= 0 && index < names.length;
    }

    private static void printCollection(String[] array) {
        long blackListed = filterArray(array, "Blacklisted");
        long lost = filterArray(array, "Lost");

        System.out.printf("Blacklisted names: %d\n", blackListed);
        System.out.printf("Lost names: %d\n", lost);
        System.out.println(String.join(" ", array));
    }

    private static void printResult(String name, String message) {
        System.out.printf("%s %s\n", name, message);
    }
}




