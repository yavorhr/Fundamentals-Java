import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double sizeSide = Double.parseDouble(scanner.nextLine());
        int sheets = Integer.parseInt(scanner.nextLine());
        double areaPerSheet = Double.parseDouble(scanner.nextLine());

        double boxArea = sizeSide * sizeSide * 6;
        double sheetsArea = 0;

        for (int i = 1; i <= sheets; i++) {
            double currentArea = areaPerSheet;

            if (i % 3 == 0) {
                currentArea *= 0.25;
            }
            sheetsArea += currentArea;
        }
        double percent = (sheetsArea / boxArea) * 100;

        System.out.printf("You can cover %.2f%% of the box.", percent);
    }
}


























