import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String country = scanner.nextLine();

        String spokenLanguagePerCountry = getLanguage(country);
        System.out.println(spokenLanguagePerCountry);
    }

    private static String getLanguage(String country) {
        String result = "";

        switch (country) {
            case "USA", "England" -> result = "English";
            case "Spain", "Argentina", "Mexico" -> result = "Spanish";
            default -> result = "unknown";
        }
        return result;
    }
}
