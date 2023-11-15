import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Double> priceMap = new HashMap<>();
        LinkedHashMap<String, Integer> quantityMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"buy".equals(input)) {
            String[] tokens = input.split(" ");
            String productKey = tokens[0];

            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            priceMap.put(productKey, price);
            quantityMap.putIfAbsent(productKey, 0);

            int newQuantity = quantityMap.get(productKey) + quantity;
            quantityMap.put(productKey,newQuantity);

            input = scanner.nextLine();
        }

        quantityMap.forEach((k, v) -> System.out.printf("%s -> %.2f\n", k, v * priceMap.get(k)));
    }
}



