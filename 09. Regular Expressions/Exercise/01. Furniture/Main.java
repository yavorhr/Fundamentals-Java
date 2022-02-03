import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = ">>(?<product>[A-Za-z]*)<<(?<price>\\d+\\.?\\d+)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        double sum = 0;
        List<String> purchaseItems = new LinkedList<>();

        String input = scanner.nextLine();
        while (!"Purchase".equals(input)) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String furniture = matcher.group("product");
                purchaseItems.add(furniture);
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));

                double currentSum = quantity*price;
                sum += currentSum;
            }

            input = scanner.nextLine();
        }

        System.out.println("Bought furniture: ");

        for (String purchaseItem : purchaseItems) {
            System.out.println(purchaseItem);
        }

        System.out.println(String.format("Total money spend: %.2f", sum));
    }
}

