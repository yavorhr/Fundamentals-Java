import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "(?<toDecypher>^(?<artist>[A-Z][a-z ']+):(?<song>[A-Z ]+))";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String toDecypher = matcher.group("toDecypher");
                String artist = matcher.group("artist");
                String song = matcher.group("song");

                String result = encryptString(artist, song, toDecypher);
                printResult("Successful encryption:", result);
            } else {
                printResult("Invalid input!");
            }

            input = scanner.nextLine();
        }
    }

    private static void printResult(String... strings) {
        if (strings.length == 2) {
            System.out.printf("%s %s\n", strings[0], strings[1]);
        } else {
            System.out.println(strings[0]);
        }
    }

    private static String encryptString(String artist, String song, String toDecypher) {
        StringBuilder sb = new StringBuilder();
        toDecypher = toDecypher.replace(':', '@');
        int key = artist.length();

        for (int i = 0; i < toDecypher.length(); i++) {
            char currentChar = toDecypher.charAt(i);

            if (currentChar != ' ' && currentChar != '@' && currentChar != '\'') {
                int newChar = currentChar + key;

                if (Character.isUpperCase(currentChar)) {
                    newChar = getNewCharDec(newChar, 90, 64);
                } else {
                    newChar = getNewCharDec(newChar, 122, 96);
                }
                sb.append((char) newChar);
            } else {
                sb.append(currentChar);
            }
        }

        return sb.toString();
    }

    private static int getNewCharDec(int currentCharPlusKey, int upperBound, int lowerBound) {
        if (currentCharPlusKey > upperBound) {
            int diff = currentCharPlusKey - upperBound;
            return lowerBound + diff;
        } else {
            return currentCharPlusKey;
        }
    }
}




