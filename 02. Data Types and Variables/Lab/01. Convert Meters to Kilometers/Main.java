import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distanceMeters = Integer.parseInt(scanner.nextLine());
        double distanceKm = distanceMeters * 1.0 / 1000;

        System.out.printf("%.2f", distanceKm);
    }
}
