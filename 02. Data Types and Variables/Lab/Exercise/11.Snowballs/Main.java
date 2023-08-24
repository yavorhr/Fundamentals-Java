import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSnowballs = Integer.parseInt(scanner.nextLine());
        double bestSnowball = Double.MIN_VALUE;

        int bestSnowballSnow = 0;
        int bestSnowballTime = 0;
        int bestSnowballQuality = 0;

        for (int i = 0; i < numberOfSnowballs; i++) {
            int snow = Integer.parseInt(scanner.nextLine());
            int time = Integer.parseInt(scanner.nextLine());
            int quality = Integer.parseInt(scanner.nextLine());

            double currentSnowball = calcStats(snow, time, quality);

            if (currentSnowball > bestSnowball) {
                bestSnowball = currentSnowball;
                bestSnowballSnow = snow;
                bestSnowballTime = time;
                bestSnowballQuality = quality;
            }
        }
        printResult(bestSnowballSnow, bestSnowballTime, bestSnowballQuality);
    }

    private static void printResult(int bestSnowballSnow, int bestSnowballTime, int bestSnowballQuality) {
        System.out.printf("%d : %d = %.0f (%d)", bestSnowballSnow, bestSnowballTime, calcStats(bestSnowballSnow, bestSnowballTime, bestSnowballQuality), bestSnowballQuality);
    }

    private static double calcStats(int snow, int time, int quality) {
        return Math.pow((snow * 1.0 / time), quality);
    }
}
