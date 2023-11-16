import java.util.*;
import java.util.stream.DoubleStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        HashMap<String, List<Double>> studentsGrades = new HashMap<>();

        for (int i = 0; i < count; i++) {
            String studentName = scanner.nextLine();
            double gradeInput = Double.parseDouble(scanner.nextLine());

            studentsGrades.putIfAbsent(studentName, new ArrayList<>());

            addGradeToStudent(studentsGrades, studentName, gradeInput);
        }

        studentsGrades
                .entrySet()
                .stream()
                .filter(entry -> {
                    double average = getAverage(entry);
                    return average >= 4.50;
                })
                .sorted((student1, student2) -> {
                    double firstAvg = getAverage(student1);
                    double secondAvg = getAverage(student2);
                    return Double.compare(firstAvg, secondAvg);
                })
                .forEach(s ->
                        System.out.printf("%s -> %.2f\n", s.getKey(), getAverage(s)));
    }

    private static void addGradeToStudent(HashMap<String, List<Double>> studentsGrades, String studentName, double gradeInput) {
        List<Double> currentGrades = studentsGrades.get(studentName);
        currentGrades.add(gradeInput);
        studentsGrades.put(studentName, currentGrades);
    }

    private static double getAverage(Map.Entry<String, List<Double>> entry) {
        return entry.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
    }
}




