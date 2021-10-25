import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sumChars = 0;

        int count = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            int symbol = scanner.nextLine().charAt(0);

            sumChars += symbol;
        }
        System.out.println("The sum equals: " + sumChars);
    }
}

