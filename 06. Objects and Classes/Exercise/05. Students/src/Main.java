import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

//Students
//Write a program that receives n count of students and orders them by grade (in descending). Each student should
//have first name (string), last name (string) and grade (floating-point number).
//Input
//• First line will be a number n
//• Next n lines you will get a student info in the format "{first name} {second name} {grade}"
//Output
//• Print each student in the following format "{first name} {second name}: {grade}"
//Example
//Input
//4
//Lakia Eason 3.90
//Prince Messing 5.49
//Akiko Segers 4.85
//Rocco Erben 6.00
//Output:
//Rocco Erben: 6.00
//Prince Messing: 5.49
//Akiko Segers: 4.85
//Lakia Eason: 3.90

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


