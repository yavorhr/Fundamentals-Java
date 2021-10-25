import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte count = Byte.parseByte(scanner.nextLine());
        double bestKegVolume = -1.0;

        String bestModel = "";

        for (int i = 0; i < count; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * Math.pow(radius, 2) * height;

            if (volume > bestKegVolume) {
                bestKegVolume = volume;
                bestModel = model;
            }
        }

        System.out.println(bestModel);
    }
}
