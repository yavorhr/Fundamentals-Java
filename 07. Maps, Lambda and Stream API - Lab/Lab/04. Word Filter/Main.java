import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] words = scanner.nextLine().split(" ");
        Arrays.stream(words)
                .filter(x -> x.length() % 2 == 0)
                .forEach(System.out::println);
    }
}


