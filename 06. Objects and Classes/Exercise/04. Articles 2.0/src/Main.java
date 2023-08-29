import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();

        addStudentToList(scanner, n, students);
        students = sortStudentsList(students);
        printStudents(students);
    }

    private static void printStudents(List<Student> students) {
        students.forEach(System.out::println);
    }

    private static List<Student> sortStudentsList(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparing(Student::getGrade).reversed())
                .collect(Collectors.toList());
    }

    private static void addStudentToList(Scanner scanner, int n, List<Student> students) {
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[0];
            double grade = Double.parseDouble(input[2]);
            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }
    }
}


