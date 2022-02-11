import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] booksText = scanner.nextLine().split("&");
        List<String> booksShelf = new ArrayList<>();
        booksShelf.addAll(Arrays.asList(booksText));

        String input = scanner.nextLine();
        while (!"Done".equals(input)) {
            String[] tokens = input.split(" \\| ");
            String command = tokens[0];
            String bookName = tokens[1];
            switch (command) {
                case "Add Book":
                    if (!booksShelf.contains(bookName)) {
                        booksShelf.add(0, bookName);
                    }
                    break;
                case "Take Book":
                    if (booksShelf.contains(bookName)) {
                        booksShelf.remove(bookName);
                    }
                    break;
                case "Swap Books":
                    String otherBook = tokens[2];
                    if (booksShelf.contains(bookName) && booksShelf.contains(otherBook)) {
                        Collections.swap(booksShelf, booksShelf.indexOf(bookName), booksShelf.indexOf(otherBook));
                    }
                    break;
                case "Insert Book":
                    booksShelf.add(bookName);
                    break;
                case "Check Book":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < booksShelf.size()) {
                        System.out.println(booksShelf.get(index));
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(String.join(", ",booksShelf));
    }
}

















