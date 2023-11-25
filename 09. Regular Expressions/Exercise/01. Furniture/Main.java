import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile(">>(?<product>[A-Za-z]*)<<(?<price>\\d+.?\\d+)!(?<quantity>\\d+)");

        List<String> products = new ArrayList<>();

        double sum = 0.0;

        String input = scanner.nextLine();
        while (!"Purchase".equals(input)) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String currentProduct = matcher.group("product");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                sum += price * quantity;
                products.add(currentProduct);
            }
            input = scanner.nextLine();
        }

        printResult(products, sum);
    }

    private static void printResult(List<String> products, double sum) {
        System.out.println("Bought furniture:");
        products.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", sum);
    }
}
