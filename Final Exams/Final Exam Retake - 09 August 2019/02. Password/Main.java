import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^(.+)>(?<onlyDigits>\\d{3})\\|(?<lowerCases>[a-z]{3})\\|(?<upperCases>[A-Z]{3})\\|(?<anyExcept>[^<>]{3})<\\1$";
        Pattern pattern = Pattern.compile(regex);

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){
                String onlyDigits = matcher.group("onlyDigits");
                String lowerCases = matcher.group("lowerCases");
                String upperCases = matcher.group("upperCases");
                String anyExcept = matcher.group("anyExcept");
                System.out.println(String.format("Password: %s%s%s%s",onlyDigits,lowerCases,upperCases,anyExcept));
            } else {
                System.out.println("Try another password!");
            }
        }
    }
}





