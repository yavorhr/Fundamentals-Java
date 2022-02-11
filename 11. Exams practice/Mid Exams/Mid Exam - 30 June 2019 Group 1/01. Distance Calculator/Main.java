import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int steps = Integer.parseInt(scanner.nextLine());
        double lengthStep = Double.parseDouble(scanner.nextLine());
        int distanceTarget = Integer.parseInt(scanner.nextLine());
        double sumSteps = 0;

        for (int i = 1; i <= steps; i++) {
            double currentStep = lengthStep;
            if (i % 5 == 0) {
                currentStep = lengthStep * 0.7;
            }
            sumSteps += currentStep;
        }

        sumSteps /=100;
        double percentage = (sumSteps/distanceTarget)*100;

        System.out.printf("You travelled %.2f%% of the distance!",percentage);
    }
}






























