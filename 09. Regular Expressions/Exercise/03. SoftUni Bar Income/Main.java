import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "%(?<name>[A-Z][a-z]+)%[^|%%.]*<(?<product>\\w+)>[^|%%.]*\\|(?<count>\\d+)\\|[^|%%.]*?(?<price>\\d+\\.?\\d+)\\$";
        Pattern pattern = Pattern.compile(regex);

        double totalPrice=0;
        String input = scanner.nextLine();
        while (!"end of shift".equals(input)) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double price = Double.parseDouble(matcher.group("price"));

                double currentPrice = count * price;
                totalPrice += currentPrice;
                System.out.println(String.format("%s: %s - %.2f",name,product,currentPrice));
            }

            input = scanner.nextLine();
        }

        System.out.println(String.format("Total income: %.2f",totalPrice));
    }
}



