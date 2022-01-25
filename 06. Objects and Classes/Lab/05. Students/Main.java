import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static class Student {
        private String firstName;
        private String lastName;
        private int age;
        private String city;

        Student(String firstName, String lastName, int age, String city) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.city = city;
        }

        public String getCity() {
            return this.city;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public int getAge() {
            return this.age;
        }

        public void setCity(String city) {
            this.city = city;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String listOfStudents = scanner.nextLine();
        List<Student> allStudents = new ArrayList<>();

        while (!"end".equals(listOfStudents)) {
            String[] tokens = listOfStudents.split(" ");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String city = tokens[3];

            Student currentStudent = new Student(firstName, lastName, age, city);
            allStudents.add(currentStudent);

            listOfStudents = scanner.nextLine();
        }

        String city = scanner.nextLine();

        for (Student student : allStudents) {
            if (city.equals(student.getCity())) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
        }

    }
}
















