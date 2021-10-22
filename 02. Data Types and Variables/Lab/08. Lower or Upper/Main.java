import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLetter = scanner.nextLine();

        if (firstLetter == firstLetter.toLowerCase()) {
            System.out.println("lower-case");
        } else if (firstLetter == firstLetter.toUpperCase()) {
            System.out.println("upper-case");
        }

    }
}
