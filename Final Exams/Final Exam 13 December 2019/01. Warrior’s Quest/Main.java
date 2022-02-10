import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();

        String input = scanner.nextLine();
        while (!"For Azeroth".equals(input)) {
            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command) {
                case "GladiatorStance":
                    string = string.toUpperCase();
                    System.out.println(string);
                    break;
                case "DefensiveStance":
                    string = string.toLowerCase();
                    System.out.println(string);
                    break;
                case "Dispel":
                    int index = Integer.parseInt(parts[1]);
                    String letter = parts[2];

                    if (index < string.length() && index >= 0) {      //to check
                        StringBuilder sb = new StringBuilder(string);
                        sb.replace(index, index + 1, letter);
                        string = sb.toString();
                        System.out.println("Success!");
                    } else {
                        System.out.println("Dispel too weak.");
                    }
                    break;
                case "Target":

                    if ("Change".equals(parts[1])) {
                        String stringToFind = parts[2];
                        String stringToReplace = parts[3];
                        string = string.replace(stringToFind, stringToReplace);
                        System.out.println(string);
                    } else if ("Remove".equals(parts[1])) {
                        String toReplace = parts[2];
                        string = string.replace(toReplace, "");
                        System.out.println(string);
                    } else {
                        System.out.println("Command doesn't exist!");
                    }
                    break;
                default:
                    System.out.println("Command doesn't exist!");
            }
            input = scanner.nextLine();
        }

    }
}


