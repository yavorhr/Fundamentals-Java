import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int steps = Integer.parseInt(scanner.nextLine());
        double lengthPerStepInCm = Double.parseDouble(scanner.nextLine());
        int distanceInMeters = Integer.parseInt(scanner.nextLine());

        int shorterStepsCount = steps / 5;
        double shorterStepsCoverageInCm = shorterStepsCount * (lengthPerStepInCm * 0.7);

        double coverDistanceInCm = ((steps - shorterStepsCount) * lengthPerStepInCm) + shorterStepsCoverageInCm;
        double coveredDistanceInMeters = coverDistanceInCm / 100;

        double coveredPercent = coveredDistanceInMeters / distanceInMeters * 100;

        System.out.printf("You travelled %.2f%% of the distance!", coveredPercent);
    }
}




