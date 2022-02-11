import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsCnt = Integer.parseInt(scanner.nextLine());
        int lecturesCnt = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());


        double maxBonus = 0;
        int bestAttend = 0;

        for (int i = 0; i < studentsCnt; i++) {
            int attendanciesCnt = Integer.parseInt(scanner.nextLine());

            if (attendanciesCnt > bestAttend) {
                bestAttend = attendanciesCnt;
            }
            double currentBonus = (attendanciesCnt * 1.0 / (lecturesCnt * 1.0)) * (5 + bonus);
            if (currentBonus > maxBonus) {
                maxBonus = currentBonus;

            }
        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.%n", bestAttend);
    }
}











