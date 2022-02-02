import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        int lastSlash = path.lastIndexOf('\\');
        int lastDot = path.lastIndexOf('.');

        String fileName = path.substring(lastSlash + 1, lastDot);
        String extension = path.substring(lastDot + 1);

        System.out.println(String.format("File name: %s", fileName));
        System.out.println(String.format("File extension: %s", extension));
    }
}

