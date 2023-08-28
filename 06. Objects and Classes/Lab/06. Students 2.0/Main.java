import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentsList = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            addStudent(studentsList, input);

            input = scanner.nextLine();
        }

        String cityInput = scanner.nextLine();
        printResult(studentsList, cityInput);
    }

    private static void printResult(List<Student> studentsList, String cityInput) {
        studentsList.stream().filter(s -> s.getCity().equals(cityInput)).forEach(System.out::println);
    }

    private static void addStudent(List<Student> studentsList, String input) {
        String[] tokens = input.split(" ");
        String firstName = tokens[0];
        String lastName = tokens[1];
        int age = Integer.parseInt(tokens[2]);
        String city = tokens[3];

        boolean studentAlreadyExists = isStudentExisting(firstName, lastName, studentsList);

        if (studentAlreadyExists) {
            Student student = getStudent(firstName, lastName, studentsList);
            student.setAge(age);
            student.setCity(city);
        } else {
            Student student = new Student(firstName, lastName, age, city);
            studentsList.add(student);
        }
    }

    private static Student getStudent(String firstName, String lastName, List<Student> studentsList) {
        Student existingStudent = null;

        for (Student student : studentsList) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }
        return existingStudent;
    }

    private static boolean isStudentExisting(String firstName, String lastName, List<Student> studentsList) {
        for (Student student : studentsList) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }
}


