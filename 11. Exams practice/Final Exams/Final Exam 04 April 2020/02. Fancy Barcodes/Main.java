import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "(@#+)(?<barcode>[A-Z][A-Za-z|0-9]{4,}[A-Z])\\1";
        Pattern pattern = Pattern.compile(regex);
        StringBuilder result = new StringBuilder();

        while (n-- > 0) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String barcode = matcher.group("barcode");
                result.append(getProductGroup(barcode)).append(System.lineSeparator());
            } else {
                result.append("Invalid barcode\n");
            }
        }

        System.out.println(result);
    }

    private static String getProductGroup(String barcode) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < barcode.length(); i++) {
            char currentChar = barcode.charAt(i);
            if (Character.isDigit(currentChar)) {
                sb.append(currentChar);
            }
        }

        return sb.length() == 0
                ? "Product group: 00"
                : String.format("Product group: %s", sb);
    }
}




