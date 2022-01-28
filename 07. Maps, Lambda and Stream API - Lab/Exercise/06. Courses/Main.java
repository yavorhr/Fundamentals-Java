import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String[] tokens = input.split(" : ");
            String nameCourse = tokens[0];
            String student = tokens[1];

            courses.putIfAbsent(nameCourse, new ArrayList<>());
            List<String> students = courses.get(nameCourse);
            students.add(student);
            //courses.get(nameCourse).add(student);

            input = scanner.nextLine();
        }

        courses
                .entrySet()
                .stream()
                .sorted((course1, course2) -> Integer.compare(course2.getValue().size(), course1.getValue().size()))
                .forEach(entry -> {
                    System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue().size()));
                    entry
                            .getValue()
                            .stream()
                            .sorted((student1, student2) -> student1.compareTo(student2))
                            .forEach(s -> System.out.println(String.format("-- %s", s)));
                });
    }
}

