import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "U\\$(?<username>[A-Z][a-z]{2,})U\\$P@\\$(?<password>[A-Za-z]{5,}\\d+)P@\\$";
        Pattern pattern = Pattern.compile(regex);

        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                count++;
                String username = matcher.group("username");
                String password = matcher.group("password");
                System.out.println("Registration was successful");
                System.out.println(String.format("Username: %s, Password: %s",username,password));
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.println(String.format("Successful registrations: %d",count));
    }
}






