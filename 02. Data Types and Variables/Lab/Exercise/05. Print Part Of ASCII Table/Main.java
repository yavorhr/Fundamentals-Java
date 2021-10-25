import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstSymbol = Integer.parseInt(scanner.nextLine());
        int secondSymbol = Integer.parseInt(scanner.nextLine());

        for (int i = firstSymbol; i <= secondSymbol; i++) {
            System.out.printf("%c ", i);
        }

    }
}
