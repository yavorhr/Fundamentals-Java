import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phrases = new String[]{"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.", "Exceptional product.", "I can’t live without this product."};
        String[] events = new String[]{"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        int count = Integer.parseInt(scanner.nextLine());

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            String phrase = phrases[random.nextInt(phrases.length)];
            String event = phrases[random.nextInt(events.length)];
            String author = phrases[random.nextInt(authors.length)];
            String city = phrases[random.nextInt(cities.length)];

            System.out.printf("%s %s %s - %s%n", phrase, event, author, city);
        }

    }
}













