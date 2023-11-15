import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> mapResourcesAndQuantities = new HashMap<>();

        String resource = scanner.nextLine();
        while (!"stop".equals(resource)) {
            int quantity = Integer.parseInt(scanner.nextLine());

            mapResourcesAndQuantities.putIfAbsent(resource, 0);

            addQuantityToExistingResource(mapResourcesAndQuantities, resource, quantity);

            resource = scanner.nextLine();
        }

        printResult(mapResourcesAndQuantities);
    }

    private static void printResult(HashMap<String, Integer> mapResourcesAndQuantities) {
        for (Map.Entry<String, Integer> entrySet : mapResourcesAndQuantities.entrySet()) {
            System.out.printf("%s - %d\n",entrySet.getKey(), entrySet.getValue() );
        }
    }

    private static void addQuantityToExistingResource(HashMap<String, Integer> mapResourcesAndQuantities, String resource, int quantity) {
        int currentQuantity = mapResourcesAndQuantities.get(resource) + quantity;
        mapResourcesAndQuantities.put(resource, currentQuantity);
    }
}


