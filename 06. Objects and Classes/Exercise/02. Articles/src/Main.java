import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Article article = getArticle(scanner);
        modifyArticle(scanner, article);

        System.out.println(article);
    }

    private static Article getArticle(Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        String title = input[0];
        String content = input[1];
        String author = input[2];

        return new Article(title, content, author);
    }

    private static void modifyArticle(Scanner scanner, Article article) {
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String command = input.split(": ")[0];
            String newValue = input.split(": ")[1];

            switch (command) {
                case "Edit" -> article.edit(newValue);
                case "ChangeAuthor" -> article.changeAuthor(newValue);
                case "Rename" -> article.rename(newValue);
            }
        }
    }
}


