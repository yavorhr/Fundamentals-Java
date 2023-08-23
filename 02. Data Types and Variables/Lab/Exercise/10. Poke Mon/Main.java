import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine()); //N
        int initialPokePower = pokePower;
        int distance = Integer.parseInt(scanner.nextLine()); //M
        byte exhaustionFactor = Byte.parseByte(scanner.nextLine()); //Y

        int targetsCount = 0;

        while (pokePower >= distance) {
            pokePower -= distance;
            targetsCount++;

            boolean halfTired = initialPokePower / pokePower == 2;
            boolean isSafeToDelete = exhaustionFactor > 0;

            if (halfTired && isSafeToDelete) {
                pokePower = pokePower / exhaustionFactor;
            }
        }

        System.out.println(pokePower);
        System.out.println(targetsCount);
    }
}
