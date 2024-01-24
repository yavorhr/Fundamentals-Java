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

                String result = decypher(artist, song, toDecypher);
                System.out.println();
            }

            input = scanner.nextLine();
        }
    }

    private static String decypher(String artist, String song, String toDecypher) {
        StringBuilder sb = new StringBuilder();
        toDecypher = toDecypher.replace(':', '@');
        int key = artist.length();

        for (int i = 0; i < toDecypher.length(); i++) {
            char currentChar = toDecypher.charAt(i);
            int newLength = currentChar + key;

            if (currentChar != ' ' && currentChar != '\'' && currentChar != '@') {

                if (Character.isUpperCase(currentChar)) {
                    if (newLength > 90) {
                        newChar -= 90;
                    }
                } else {
                    if (newChar > 122) {
                        newChar -= 122;
                    }
                }

                char newChar = currentChar += key;


                sb.append(newChar);
            } else {
                sb.append(currentChar);
            }
        }
        return sb.toString();
    }
}




