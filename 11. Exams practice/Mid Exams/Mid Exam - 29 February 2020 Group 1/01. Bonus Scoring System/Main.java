import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCount = Integer.parseInt(scanner.nextLine());
        int lecturesCount = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        double maxBonus = 0;
        int mostAttended = 0;

        for (int i = 0; i < studentsCount; i++) {
            int currentAttendance = Integer.parseInt(scanner.nextLine());

            double currentBonus = (currentAttendance * 1.0 / (lecturesCount * 1.0)) * (5 + bonus);

            if (currentBonus > maxBonus) {
                maxBonus = currentBonus;
                mostAttended = currentAttendance;
            }
        }

        printResult(maxBonus, mostAttended);
    }

    private static void printResult(double maxBonus, int mostAttended) {
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.%n", mostAttended);
    }
}




