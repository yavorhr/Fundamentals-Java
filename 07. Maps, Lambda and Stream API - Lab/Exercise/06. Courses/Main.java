import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, List<String>> courses = new HashMap<>();

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split(" : ");
            String courseName = tokens[0];
            String studentName = tokens[1];

            courses.putIfAbsent(courseName, new ArrayList<>());

            addStudentToCourse(courses, courseName, studentName);

            input = scanner.nextLine();
        }
        printResult(courses);
    }

    private static void printResult(HashMap<String, List<String>> courses) {
        courses
                .entrySet()
                .stream()
                .sorted((courses1, course2) -> Integer.compare(course2.getValue().size(), courses1.getValue().size()))
                .forEach(entry -> {
                    System.out.printf("%s: %d\n", entry.getKey(), entry.getValue().size());

                    entry.getValue()
                            .stream()
                            .sorted((student1, student2) -> student1.compareTo(student2))
                            .forEach(s -> System.out.printf("-- %s\n", s));
                });
    }

    private static void addStudentToCourse(HashMap<String, List<String>> courses, String courseName, String studentName) {
        List<String> students = courses.get(courseName);
        students.add(studentName);
        courses.put(courseName, students);
    }
}




