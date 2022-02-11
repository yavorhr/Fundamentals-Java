import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int countPeople = Integer.parseInt(scanner.nextLine());
        int peopleEffPerHour = firstEmployee + secondEmployee + thirdEmployee;

        int timeNeeded = 0;
        int days = 0;

        while (countPeople > 0) {
            countPeople -= peopleEffPerHour;
            timeNeeded++;
            if (timeNeeded % 4 == 0 && timeNeeded != 0) {
                timeNeeded++;
                if (timeNeeded >= 24) {
                    days++;
                    timeNeeded = timeNeeded - 24;
                }
            }
        }
        System.out.printf("Time needed: %dh.", days * 24 + timeNeeded);
    }
}






