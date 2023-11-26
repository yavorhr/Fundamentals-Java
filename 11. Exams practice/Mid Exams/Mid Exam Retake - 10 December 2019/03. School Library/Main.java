import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> books = Arrays.stream(scanner.nextLine().split("&")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!"Done".equals(input)) {
            String[] tokens = input.split(" \\| ");
            String command = tokens[0];

            switch (command) {
                case "Add Book" -> {
                    String book = tokens[1];
                    if (!doesBookExist(books, book)) {
                        books.add(0, book);
                    }
                }
                case "Take Book" -> {
                    String book = tokens[1];
                    books.remove(book);
                }
                case "Swap Books" -> {
                    String firstBook = tokens[1];
                    String secondBook = tokens[2];

                    swapBooks(books, firstBook, secondBook);
                }
                case "Insert Book" -> {
                    String book = tokens[1];
                    if (!doesBookExist(books, book)) {
                        books.add(book);
                    }
                }
                case "Check Book" -> {
                    int index = Integer.parseInt(tokens[1]);
                    if (isIndexValid(books, index)) {
                        System.out.println(books.get(index));
                    }
                }
            }
            input = scanner.nextLine();
        }

        printResult(books);
    }

    private static void printResult(List<String> books) {
        System.out.println(String.join(", ", books));
    }

    private static boolean isIndexValid(List<String> books, int index) {
        return index >= 0 && index < books.size();
    }

    private static boolean doesBookExist(List<String> books, String book) {
        return books.contains(book);
    }

    private static void swapBooks(List<String> books, String firstBook, String secondBook) {
        int firstIndex = books.indexOf(firstBook);
        int secondIndex = books.indexOf(secondBook);

        Collections.swap(books,firstIndex,secondIndex);
    }
}
