import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String outputString = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"Travel".equals(input)) {
            String[] tokens = input.split(":");
            String command = tokens[0];

            switch (command) {
                case "Add Stop" -> {
                    int index = Integer.parseInt(tokens[1]);
                    String stringToInsert = tokens[2];

                    if (indexIsValid(index, outputString)) {
                        outputString = new StringBuilder(outputString).insert(index, stringToInsert).toString();
                    }
                }
                case "Remove Stop" -> {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (indexIsValid(startIndex, outputString) && indexIsValid(endIndex, outputString)) {
                        outputString = new StringBuilder(outputString).delete(startIndex, endIndex + 1).toString();
                    }
                }
                case "Switch" -> {
                    String oldString = tokens[1];
                    String newString = tokens[2];

                    if (outputString.contains(oldString)) {
                        outputString = outputString.replace(oldString, newString);
                    }
                }
            }
            printResult(outputString);
            input = scanner.nextLine();
        }

        printResult(String.format("Ready for world tour! Planned stops: %s", outputString));
    }

    private static void printResult(String outputString) {
        System.out.println(outputString);
    }

    private static boolean indexIsValid(int index, String outputString) {
        return index >= 0 && index < outputString.length();
    }


}




