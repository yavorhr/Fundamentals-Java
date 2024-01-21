import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isFound = false;

        String regex = "(?<symbol>[#$%*$])(?<name>[A-za-z]+)\\1=(?<length>\\d+)!!(?<geohashcode>.+)$";
        Pattern pattern = Pattern.compile(regex);

        while (!isFound) {
            String input = scanner.nextLine();

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                int length = Integer.parseInt(matcher.group("length"));
                String coordinates = matcher.group("geohashcode");

                if (length != coordinates.length()) {
                    printNothingFound();
                } else {
                    System.out.printf("Coordinates found! %s -> %s", name, getCoordinates(coordinates, length));
                    isFound = true;
                }
            } else {
                printNothingFound();
            }
        }
    }

    private static void printNothingFound() {
        System.out.println("Nothing found!");
    }

    private static String getCoordinates(String code, int length) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < code.length(); i++) {
            char currentChar = code.charAt(i);
            int modifiedChar = currentChar + length;

            sb.append(String.format("%c",modifiedChar));
        }
        return sb.toString();
    }
}




