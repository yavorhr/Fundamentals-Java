import java.util.*;

public class Main {
    private static int EMPLOYEES_COUNT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employeeTogetherPerHour = 0;
        while (EMPLOYEES_COUNT-- > 0) {
            int studentsPerHour = Integer.parseInt(scanner.nextLine());
            employeeTogetherPerHour += studentsPerHour;
        }

        int totalStudentsForTheDay = Integer.parseInt(scanner.nextLine());

        int hours = totalStudentsForTheDay / employeeTogetherPerHour;
        int remainder = totalStudentsForTheDay % employeeTogetherPerHour;

        if (remainder > 0) {
            hours += 1;
        }

        int breaks = hours / 4;
        int totalTime = breaks + hours;

        System.out.printf("Time needed: %d.", totalTime);
    }
}




