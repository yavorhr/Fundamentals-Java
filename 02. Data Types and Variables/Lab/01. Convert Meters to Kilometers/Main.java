import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distanceInMeters = Integer.parseInt(scanner.nextLine());
        printMetersInKm(distanceInMeters);
    }

    private static void printMetersInKm(int distanceInMeters) {
        double distanceInKm = distanceInMeters / 1000.00;
        System.out.printf("%.2f",distanceInKm);
    }
}