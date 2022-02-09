
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int employeeOne = Integer.parseInt(scanner.nextLine());
        int employeeTwo = Integer.parseInt(scanner.nextLine());
        int employeeThree = Integer.parseInt(scanner.nextLine());

        int studentsCount = Integer.parseInt(scanner.nextLine());
        int employeeTogether = employeeOne + employeeTwo + employeeThree;

        int hour = studentsCount / employeeTogether;
        if (studentsCount % employeeTogether > 0) {
            hour++;
        }

        for (int i = 1; i <= hour; i++) {
            if (i % 4 == 0) {
                hour++;
            }
        }
        System.out.printf("Time needed: %dh.",hour);
    }
}

