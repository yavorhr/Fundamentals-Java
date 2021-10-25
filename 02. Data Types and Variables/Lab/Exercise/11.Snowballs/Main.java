import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        double bestSnowball = 0;
        int bestSnow = 0;
        int bestSnowballTime = 0;
        int bestSnowballQuality = 0;


        for (int i = 0; i < count; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            int snowAndTime = snowballSnow / snowballTime;
            double currentSnowball = Math.pow(snowAndTime * 1.0, snowballQuality);

            if (currentSnowball > bestSnowball) {
                bestSnowball = currentSnowball;
                bestSnow = snowballSnow;
                bestSnowballTime = snowballTime;
                bestSnowballQuality = snowballQuality;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)", bestSnow, bestSnowballTime, bestSnowball, bestSnowballQuality);
        //{snowballSnow} : {snowballTime} = {snowballValue} ({snowballQuality})
    }
}


