import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger firstN = readBigInteger(scanner);
        BigInteger secondN = readBigInteger(scanner);

        BigInteger result = sumBigIntegers(firstN, secondN);
        System.out.println(result);
    }

    private static BigInteger sumBigIntegers(BigInteger firstN, BigInteger secondN) {
        return firstN.add(secondN);
    }

    private static BigInteger readBigInteger(Scanner scanner) {
        return new BigInteger(scanner.nextLine());
    }
}

