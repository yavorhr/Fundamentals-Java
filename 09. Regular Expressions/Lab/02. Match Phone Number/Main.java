import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String phone = scanner.nextLine();
        String regex = "\\+359([ -])2\\1[\\d]{3}\\1[\\d]{4}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);

        List <String> matches = new ArrayList<>();

        while (matcher.find()){
            matches.add(matcher.group());
        }

        System.out.println(String.join(", ",matches));
    }
}

