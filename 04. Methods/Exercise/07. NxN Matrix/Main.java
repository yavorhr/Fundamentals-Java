import java.util.Scanner;

public class Main {

    static int[][] nMatrixInitialization(int n) {
        int[][] resultMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultMatrix[i][j] = n;
            }
        }
        return resultMatrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] nMatrix = nMatrixInitialization(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", nMatrix[i][j]);
            }
            System.out.println();
        }
    }
}