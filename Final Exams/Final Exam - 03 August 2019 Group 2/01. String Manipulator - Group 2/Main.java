import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String input = scanner.nextLine();
        while (!"Done".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Change":
                    String toFind = tokens[1];
                    String toReplace = tokens[2];
                    if (string.contains(toFind)) {
                        string = string.replace(toFind, toReplace);
                        System.out.println(string);
                    }
                    break;
                case "Includes":
                    String ifIncludes = tokens[1];
                    if (string.contains(ifIncludes)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String checkIfMatch = tokens[1];
                    int length = checkIfMatch.length();
                    String lastChars = string.substring(string.length() - length);

                    if (lastChars.equals(checkIfMatch)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    string = string.toUpperCase();
                    System.out.println(string);
                    break;
                case "FindIndex":
                    String findChar = tokens[1];
                    System.out.println(string.indexOf(findChar));
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int legth = Integer.parseInt(tokens[2]);
                    string = string.substring(startIndex, startIndex + legth);
                    System.out.println(string);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}








