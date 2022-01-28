import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> quantityMap = new LinkedHashMap<>();
        Map<String, Double> priceMap = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!"buy".equals(line)) {
            String[] products = line.split("\\s+");
            String productKey = products[0];
            double price = Double.parseDouble(products[1]);
            int quantity = Integer.parseInt(products[2]);

            priceMap.put(productKey, price);
            quantityMap.putIfAbsent(productKey, 0);
            int newQuantity = quantityMap.get(productKey) + quantity;
            quantityMap.put(productKey, newQuantity);

            line = scanner.nextLine();
        }

        quantityMap.forEach((k, v) -> System.out.println(String.format("%s -> %.2f", k, v * priceMap.get(k))));
    }
}

