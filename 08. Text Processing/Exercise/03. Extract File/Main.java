import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();

        int lastSlashIndex = path.lastIndexOf('\\');
        int dotIndex = path.indexOf('.');

        String fileName = path.substring(lastSlashIndex + 1, dotIndex);
        String extension = path.substring(dotIndex + 1);

        printResult(fileName, extension);
    }

    private static void printResult(String fileName, String extension) {
        String result = String.format("File name: %s\nFile extension: %s", fileName, extension);
        System.out.println(result);
    }
}