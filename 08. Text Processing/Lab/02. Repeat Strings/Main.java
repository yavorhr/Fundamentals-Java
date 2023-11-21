import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        StringBuilder resultString = new StringBuilder();


        Arrays.stream(input).forEach(s -> repeatString(s, s.length(), resultString));

        System.out.println(resultString);
    }

    private static void repeatString(String currentString, int length, StringBuilder resultString) {
        resultString.append(String.valueOf(currentString).repeat(Math.max(0, length)));
    }
}