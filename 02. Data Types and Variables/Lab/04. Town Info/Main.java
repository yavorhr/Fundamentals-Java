import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String city = scanner.nextLine();
        int population = readIntegerInput(scanner);
        int area = readIntegerInput(scanner);

        printResult(city, population, area);
    }

    private static int readIntegerInput(Scanner scanner) {
        return Integer.parseInt(scanner.nextLine());
    }

    private static void printResult(String city, int population, int area) {
        System.out.printf("Town %s has population of %d and area %d square km.", city, population, area);
    }
}