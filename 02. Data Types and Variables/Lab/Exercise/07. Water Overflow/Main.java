import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte n = Byte.parseByte(scanner.nextLine());

        int tankCapacity = 255;
        int totalLiters = 0;

        boolean insufficientCapacity = false;

        for (int i = 0; i < n; i++) {
            short currentLiters = Short.parseShort(scanner.nextLine());
            if (tankCapacity < currentLiters) {
                insufficientCapacity = true;
            } else {
                totalLiters += currentLiters;
                tankCapacity -= currentLiters;
            }
        }

        if (insufficientCapacity) {
            System.out.println("Insufficient capacity!");
        }
        System.out.println(totalLiters);
    }
}
