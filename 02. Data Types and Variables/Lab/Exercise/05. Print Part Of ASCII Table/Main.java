import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startIndex = Integer.parseInt(scanner.nextLine());
        int endIndex = Integer.parseInt(scanner.nextLine());

        printResult(startIndex, endIndex);
    }

    private static void printResult(int startIndex, int endIndex) {
        for (int i = startIndex; i <= endIndex; i++) {
            System.out.printf("%c ", i);
        }
    }

}
