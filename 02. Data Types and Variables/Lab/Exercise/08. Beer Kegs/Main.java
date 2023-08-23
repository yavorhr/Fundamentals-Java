import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double biggestKegVolume = Integer.MIN_VALUE;
        String biggestKegName = "";
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double kegSize = calculateKegSize(radius, height);

            if (kegSize > biggestKegVolume) {
                biggestKegVolume = kegSize;
                biggestKegName = model;
            }
        }
        System.out.println(biggestKegName);
    }

    private static double calculateKegSize(double radius, int height) {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
