import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> frogs = Arrays.stream(scanner.nextLine()
                .split(" "))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (true) {
            String[] tokens = input.split(" ");
            if (input.contains("Print")) {

            }

        }
    }
}




