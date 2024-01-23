import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String skill = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"For Azeroth".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "GladiatorStance" -> {
                    skill = skill.toUpperCase();
                    printResult(skill);
                }
                case "DefensiveStance" -> {
                    skill = skill.toLowerCase();
                    printResult(skill);
                }
                case "Dispel" -> {
                    int index = Integer.parseInt(tokens[1]);
                    String letter = tokens[2];

                    if (!indexIsValid(index, skill)) {
                        printResult("Dispel too weak.");
                    } else {
                        StringBuilder sb = new StringBuilder(skill);
                        sb.replace(index, index + 1, letter);
                        skill = sb.toString();

                        printResult("Success!");
                    }
                }
                case "Target" -> {
                    String condition = tokens[1];
                    String substring = tokens[2];

                    if (condition.equals("Change")) {
                        String secondSubstring = tokens[3];
                        skill = skill.replace(substring, secondSubstring);
                    } else if (condition.equals("Remove")) {
                        skill = skill.replace(substring, "");
                    }

                    printResult(skill);
                }
                default -> printResult("Command doesn't exist!");
            }

            input = scanner.nextLine();
        }
    }

    private static boolean indexIsValid(int index, String skill) {
        return index >= 0 && index < skill.length();
    }

    private static void printResult(String message) {
        System.out.println(message);
    }
}




