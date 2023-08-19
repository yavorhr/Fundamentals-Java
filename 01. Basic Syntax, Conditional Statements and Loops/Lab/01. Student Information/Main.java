import java.util.Scanner;

public class Main {
    static final double BOUND_GRADE = 3.00;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String result = getResultIfGradePass(scanner);

        System.out.println(result);
    }

    private static String getResultIfGradePass(Scanner scanner) {
        double grade = Double.parseDouble(scanner.nextLine());
        String result = "";

        if (grade >= BOUND_GRADE) {
            result = "Passed!";
        }
        return result;
    }

}

