import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();

        while (n-- > 0) {
            String[] input = scanner.nextLine().split(" ");
            String firstName = input[0];
            String secondName = input[1];
            double grade = Double.parseDouble(input[2]);
            Student student = new Student(firstName, secondName, grade);
            students.add(student);
        }
        students.sort(Comparator.comparingDouble(Student::getGrade).reversed());
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}
