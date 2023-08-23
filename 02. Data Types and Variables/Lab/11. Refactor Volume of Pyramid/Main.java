import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printMeasurement("Length: ");
        double length = readDoubleFromConsole(scanner);
        printMeasurement("Width: ");
        double width = readDoubleFromConsole(scanner);
        printMeasurement("Height: ");
        double height = readDoubleFromConsole(scanner);

        double pyramidArea = calculatePyramidArea(length, width, height);

        System.out.printf("Pyramid Volume: %.2f", pyramidArea);
    }

    private static void printMeasurement(String param) {
        System.out.print(param);
    }

    private static double calculatePyramidArea(double length, double width, double height) {
        return (length + width + height) / 3;
    }

    private static double readDoubleFromConsole(Scanner scanner) {
        return Double.parseDouble(scanner.nextLine());
    }
}
