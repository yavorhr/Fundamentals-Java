import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int sumDigits = 0;
        while (number > 0) {
            sumDigits += number % 10;
            number /= 10;
        }
        System.out.println(sumDigits);
    }
}
