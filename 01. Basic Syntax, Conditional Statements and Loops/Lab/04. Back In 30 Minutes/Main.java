import java.util.Scanner;

public class Main {
    private static final int TIME_IN_30_MINUTES = 30;
    private static final int MINUTES_IN_1_HOUR = 60;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int readHours = Integer.parseInt(scanner.nextLine());
        int readMinutes = Integer.parseInt(scanner.nextLine());

        int totalMinutes = getTotalMinutes(readHours, readMinutes);

        int minutes = totalMinutes % 60;
        int hours = totalMinutes / 60;

        if (hours == 24) {
            hours = 0;
        }

        System.out.printf("%d:%02d", hours, minutes);
    }

    private static int getTotalMinutes(int hours, int minutes) {
        int convertHoursIntoMinutes = hours * MINUTES_IN_1_HOUR;
        return convertHoursIntoMinutes + minutes + TIME_IN_30_MINUTES;
    }
}
