import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> productsList = new ArrayList<>();

        addProductsToList(scanner, n, productsList);
        Collections.sort(productsList);
        printResult(productsList);
    }

    private static void printResult(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d.%s\n",i+1, list.get(i));
        }
    }

    private static void addProductsToList(Scanner scanner, int n, List<String> list) {
        for (int i = 0; i < n; i++) {
            String product = scanner.nextLine();
            list.add(product);
        }
    }
}
