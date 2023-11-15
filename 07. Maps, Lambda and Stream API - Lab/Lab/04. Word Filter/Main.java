import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split(" "))
                .filter(s -> s.length() % 2 == 0)
                .forEach(System.out::println);
    }
}


