import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int centuries = Integer.parseInt(scanner.nextLine());
        printCenturiesInMinutes(centuries);
    }

    private static void printCenturiesInMinutes(int centuries) {
        int years = centuries * 100;
        int days = (int) (years * 365.2422);
        long hours = days * 24L;
        long minutes = hours * 60;

        System.out.printf("%d centuries = %d years = %d days = %d hours = %d minutes", centuries, years, days, hours, minutes);
    }
}
