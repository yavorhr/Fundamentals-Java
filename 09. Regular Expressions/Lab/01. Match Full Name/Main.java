import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Pattern regex = Pattern.compile("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b");
        Matcher matcher = regex.matcher(input);

        printMatches(matcher);
    }

    private static void printMatches(Matcher matcher) {
        while (matcher.find()){
            System.out.print(matcher.group() + " ");
        }
    }
}
