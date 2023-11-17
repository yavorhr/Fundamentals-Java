import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sizeSideInCm = Double.parseDouble(scanner.nextLine());
        int numberOfSheets = Integer.parseInt(scanner.nextLine());
        double areaOfSingleSheet = Double.parseDouble(scanner.nextLine());
        int totalSides = 6;

        double giftArea = sizeSideInCm * sizeSideInCm * totalSides;

        double coveredArea = 0.0;
        coveredArea = calcArea(numberOfSheets, areaOfSingleSheet, coveredArea);

        double coveredPercents = calcCoveredAreaInPercents(giftArea, coveredArea);

        printResult(coveredPercents);
    }

    private static void printResult(double coveredPercents) {
        System.out.printf("You can cover %.2f%% of the box.", coveredPercents);
    }

    private static double calcCoveredAreaInPercents(double giftArea, double coveredArea) {
        return coveredArea / giftArea * 100;
    }

    private static double calcArea(int numberOfSheets, double areaOfSingleSheet, double coveredArea) {
        for (int i = 1; i <= numberOfSheets; i++) {
            double currentArea = areaOfSingleSheet;
            if (i % 3 == 0) {
                currentArea *= 0.25;
            }
            coveredArea += currentArea;
        }
        return coveredArea;
    }
}




