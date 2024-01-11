import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "^(?<name>[!@#$?A-Za-z\\d*]+)=(?<length>\\d*)<<(?<code>.*)$";
        Pattern pattern = Pattern.compile(regex);

        String input = scanner.nextLine();
        while (!"Last note".equals(input)) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                int length = Integer.parseInt(matcher.group("length"));
                String code = matcher.group("code");

                if (length != code.length()) {
                    printNotFound();
                    input = scanner.nextLine();
                    continue;
                }
                String outputName = decypherName(name);
                printResult(code, outputName);

            } else {
                printNotFound();
            }

            input = scanner.nextLine();
        }
    }

    private static void printResult(String code, String outputName) {
        System.out.printf("Coordinates found!%s -> %s\n", outputName, code);
    }

    private static void printNotFound() {
        System.out.println("Nothing found!");
    }

    private static String decypherName(String name) {
        StringBuilder sb = new StringBuilder();
        String regex = "[A-Za-z]+";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);

        while (matcher.find()){
            sb.append(matcher.group());
        }

        return sb.toString();
    }
}

