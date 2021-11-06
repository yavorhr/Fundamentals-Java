import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());
        gradePrint(grade);
    }

    private static void gradePrint(double grade) {
        String gradeType = "";
        if (grade >= 2 && grade < 3) {
            gradeType = "Fail";
        } else if (grade >= 3 && grade < 3.50) {
            gradeType = "Poor";
        } else if (grade >= 3.50 && grade < 4.50) {
            gradeType = "Good";
        } else if (grade >= 4.50 && grade < 5.50) {
            gradeType = "Very good";
        } else if (grade >= 5.50 && grade <= 6.00) {
            gradeType = "Excellent";
        }

        System.out.println(gradeType);
    }
}

