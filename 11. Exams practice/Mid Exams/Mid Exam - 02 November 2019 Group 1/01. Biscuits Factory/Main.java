import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int biscuitsPerWorker = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        int productionOtherFactory = Integer.parseInt(scanner.nextLine());
        int days = 30;
        double sum = 0;

        for (int i = 0; i < days; i++) {
            double dailyProduction = biscuitsPerWorker * workers;
            if (i % 3 == 0) {
                dailyProduction = dailyProduction * 0.75;
            }
            sum += dailyProduction;
        }

        double differece = productionOtherFactory*1.0 - sum;
        double percentage = Math.abs((differece/productionOtherFactory)*100);

        System.out.printf("You have produced %.0f biscuits for the past month.%n",sum);
        if (sum>productionOtherFactory){
            System.out.printf("You produce %.2f percent more biscuits.%n",percentage);
        }else {
            System.out.printf("You produce %.2f percent less biscuits.%n",percentage);
        }
    }
}


















