import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pokePower = Integer.parseInt(scanner.nextLine());   //N
        int distance = Integer.parseInt(scanner.nextLine());    //M
        byte exhaustionFactor = Byte.parseByte(scanner.nextLine()); //Y
        int halfPokePower = pokePower / 2;

        int targetCount = 0;
        while (pokePower >= distance) {
            pokePower -= distance;
            targetCount++;

            boolean isSafeToDelete = exhaustionFactor > 0;

            if (pokePower == halfPokePower && isSafeToDelete) {
                pokePower = pokePower / exhaustionFactor;
            }
        }

        System.out.println(pokePower);
        System.out.println(targetCount);
    }
}

