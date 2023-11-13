import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int countPeople = Integer.parseInt(scanner.nextLine());

        int hours = 0;
        int days = 0;

        while (countPeople >= 0) {
            int peoplePerHour = firstEmployee + secondEmployee + thirdEmployee;
            countPeople -= peoplePerHour;
            hours++;

            if (hours % 4 == 0 && hours != 0) {
                hours++;

                if (hours >= 24) {
                    days++;
                    hours -= 24;
                }
            }
        }
        printResult(hours,days);
    }

    private static void printResult(int hours, int days) {
        System.out.printf("Time needed: %dh.", days * 24 + hours);
    }
}



