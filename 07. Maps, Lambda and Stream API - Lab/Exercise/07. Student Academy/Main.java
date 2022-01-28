import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map <String, List <Double>> studentGrades = new LinkedHashMap<>();

        int pairs = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < pairs; i++) {
            String student = scanner.nextLine();
            double currentGrade = Double.parseDouble(scanner.nextLine());

            studentGrades.putIfAbsent(student,new ArrayList<>());
            studentGrades.get(student).add(currentGrade);
        }

        studentGrades
                .entrySet()
                .stream()
                .filter(s -> s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble() >=4.50)
                .sorted ((s1,s2)->{
                    double first = s1.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    double second = s2.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
                    return Double.compare(second,first);
                })
                .forEach(s -> System.out.println(String.format("%s -> %.2f",
                        s.getKey(),
                        s.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble())));
    }
}


