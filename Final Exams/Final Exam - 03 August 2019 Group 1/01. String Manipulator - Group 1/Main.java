import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringManipulator = scanner.nextLine();
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Translate":
                    String findChar = tokens[1];
                    String replace = tokens[2];
                    if (stringManipulator.contains(findChar)) {
                        stringManipulator = stringManipulator.replace(findChar, replace);
                        System.out.println(stringManipulator);
                    }
                    break;
                case "Includes":
                    String string = tokens[1];
                    if (stringManipulator.contains(string)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    String anotherString = tokens[1];
                    int length = anotherString.length();
                    String substring = stringManipulator.substring(0, length);
                    if (anotherString.equals(substring)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    stringManipulator = stringManipulator.toLowerCase();
                    System.out.println(stringManipulator);
                    break;
                case "FindIndex":
                    String toFind = tokens[1];
                    int lastIndex = stringManipulator.lastIndexOf(toFind);
                    System.out.println(lastIndex);
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int count = Integer.parseInt(tokens[2]);
                    substring = stringManipulator.substring(startIndex, startIndex + count);
                    stringManipulator = stringManipulator.replace(substring, "");
                    System.out.println(stringManipulator);
                    break;
            }
            input = scanner.nextLine();
        }
    }
}












