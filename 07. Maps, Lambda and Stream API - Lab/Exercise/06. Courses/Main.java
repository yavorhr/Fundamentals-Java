import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, List<String>> courses = new HashMap<>();

        String input = scanner.nextLine();
        while ("!end".equals(input)) {
            String[] tokens = input.split(" : ");
            String courseName = tokens[0];
            String studentName = tokens[1];



            input = scanner.nextLine();
        }
    }
}




