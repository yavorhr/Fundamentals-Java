import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "@#*[A-Z][A-Za-z|0-9]{4,}[A-Z]@#+";
        Pattern pattern = Pattern.compile(regex);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String barcode = scanner.nextLine();
            Matcher matcher = pattern.matcher(barcode);

            if (matcher.find()) {
                StringBuilder sb = new StringBuilder();

                String currentBarCode = matcher.group();
                for (int j = 0; j < currentBarCode.length(); j++) {
                    char currentChar = currentBarCode.charAt(j);
                    if (Character.isDigit(currentChar)) {
                        sb.append(currentChar);
                    }
                }

                if (sb.toString().isEmpty()) {
                    System.out.println(String.format("Product group: 00"));
                } else {
                    System.out.println(String.format("Product group: %s",sb.toString()));
                }
            } else {
                System.out.println("Invalid barcode");
            }

        }
    }
}

