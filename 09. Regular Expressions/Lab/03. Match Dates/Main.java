import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile(">>(?<product>[A-Za-z]*)<<(?<price>\\d+.?\\d+)!(?<quantity>\\d+)");

        Map<String, Double> products = new HashMap<>();
        double sum = 0.0;

        String input = scanner.nextLine();
        while (!"Purchase".equals(input)) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String product = matcher.group("product");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                products.put(product, price);
            }


            input = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        products.keySet().forEach(System.out::println);

        double sum = products
                .values()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        System.out.printf("Total money spend: %.2f", sum);
    }
}
