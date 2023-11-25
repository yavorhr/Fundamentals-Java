import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "%(?<name>[A-Z][a-z]+)%[^|%%.]*<(?<product>\\w+)>[^|%%.]*\\|(?<quantity>\\d+)\\|[^|%%.]*?(?<price>\\d+\\.?\\d+)\\$";
        Pattern pattern = Pattern.compile(regex);

        double sum = 0;

        String input = scanner.nextLine();
        while (!"end of shift".equals(input)) {
            Matcher matcher = pattern.matcher(input);

            while (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));
                double total = price * quantity;

                System.out.printf("%s: %s - %.2f\n", name, product, total);
                sum += total;
            }
            input = scanner.nextLine();
        }
        printTotalSum(sum);
    }

    private static void printTotalSum(double sum) {
        System.out.printf("Total income: %.2f", sum);
    }
}
