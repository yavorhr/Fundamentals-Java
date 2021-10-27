import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte pourCnt = Byte.parseByte(scanner.nextLine());
        short capacity = 255;
        int totalLiters = 0;

        for (int i = 0; i < pourCnt; i++) {
            short liters = Short.parseShort(scanner.nextLine());

            if (capacity >= liters) {
                capacity -= liters;
                totalLiters += liters;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(totalLiters);
    }
}
