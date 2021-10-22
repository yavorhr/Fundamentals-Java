import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String allSymbols = "";

        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);
        char thirdSymbol = scanner.nextLine().charAt(0);

        allSymbols += "" + firstSymbol + secondSymbol + thirdSymbol;
        System.out.println(allSymbols);
    }
}
