import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int totalStudentsPerHour = getTotalStudentsPerHour(firstEmployee, secondEmployee, thirdEmployee);
        int hours = getTotalHours(studentsCount, totalStudentsPerHour);
        hours = checkForRemainingStudents(studentsCount, totalStudentsPerHour, hours);
        hours = calcBreaks(hours);

        printResult(hours);
    }

    private static int checkForRemainingStudents(int studentsCount, int totalStudentsPerHour, int hours) {
        if (studentsCount % totalStudentsPerHour > 0) {
            hours += 1;
        }
        return hours;
    }

    private static int getTotalHours(int studentsCount, int totalStudentsPerHour) {
        return studentsCount / totalStudentsPerHour;
    }

    private static void printResult(int hours) {
        System.out.printf("Time needed: %dh.", hours);
    }

    private static int calcBreaks(int hours) {
        for (int i = 1; i <= hours; i++) {
            if (i % 4 == 0) {
                hours++;
            }
        }
        return hours;
    }

    private static int getTotalStudentsPerHour(int firstEmployee, int secondEmployee, int thirdEmployee) {
        return firstEmployee + secondEmployee + thirdEmployee;
    }
}


