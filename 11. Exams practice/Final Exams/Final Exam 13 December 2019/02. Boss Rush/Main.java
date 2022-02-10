import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\|(?<name>[A-Z]{4,})\\|:#(?<title>[A-Za-z]+\\s[A-Za-z]+)#";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()){
                String name = matcher.group("name");
                String title = matcher.group("title");
                System.out.println(String.format("%s, The %s",name,title));
                System.out.println(String.format(">> Strength: %d",name.length()));
                System.out.println(String.format(">> Armour: %d",title.length()));
            } else {
                System.out.println("Access denied!");
            }
        }
    }
}

