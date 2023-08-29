import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Article> articleList = new ArrayList<>();
        addArticlesToList(scanner, articleList);

        String input = scanner.nextLine();
        articleList = sortListByInput(articleList, input);

        printResult(articleList);
    }

    private static void printResult(List<Article> articleList) {
        articleList.forEach(System.out::println);
    }

    private static List<Article> sortListByInput(List<Article> list, String input) {
        List<Article> sortedList = new ArrayList<>();

        if (input.equals("title")) {
            sortedList = list.stream().sorted(Comparator.comparing(Article::getTitle)).collect(Collectors.toList());
        } else if (input.equals("author")) {
            sortedList = list.stream().sorted(Comparator.comparing(Article::getAuthor)).collect(Collectors.toList());

        } else if (input.equals("content")) {
            sortedList = list.stream().sorted(Comparator.comparing(Article::getContent)).collect(Collectors.toList());
        }
        return sortedList;
    }

    private static void addArticlesToList(Scanner scanner, List<Article> articleList) {
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            Article article = getArticle(input);
            articleList.add(article);
        }
    }

    private static Article getArticle(String[] input) {
        String title = input[0];
        String content = input[1];
        String author = input[2];

        return new Article(title, content, author);
    }


}


