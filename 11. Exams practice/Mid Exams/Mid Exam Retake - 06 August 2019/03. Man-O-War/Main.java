import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pirateShipText = scanner.nextLine().split("\\>");  //pirateShip - ние
        String[] warShipText = scanner.nextLine().split("\\>");     //warShip
        int maxHealthCapacityPerSection = Integer.parseInt(scanner.nextLine());
        boolean stalemate = true;

        int[] pirateShip = new int[pirateShipText.length];
        int[] warShip = new int[warShipText.length];

        for (int i = 0; i < pirateShip.length; i++) {
            pirateShip[i] = Integer.parseInt(pirateShipText[i]);
        }
        for (int i = 0; i < warShip.length; i++) {
            warShip[i] = Integer.parseInt(warShipText[i]);
        }

        String input = scanner.nextLine();
        while (!"Retire".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Fire":
                    //•    Fire {index} {damage}
                    int sectionWarShip = Integer.parseInt(tokens[1]);
                    int damagePirateShip = Integer.parseInt(tokens[2]);

                    if (sectionWarShip >= 0 && sectionWarShip <= warShip.length - 1) {
                        warShip[sectionWarShip] -= damagePirateShip;
                        if (warShip[sectionWarShip] < 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            stalemate = false;
                            break;
                        }
                    }
                    break;
                case "Defend":
                    //•    Defend {startIndex} {endIndex} {damage}
                    int startSectionPirateShip = Integer.parseInt(tokens[1]);
                    int endSectionPirateShip = Integer.parseInt(tokens[2]);
                    int damageWarShip = Integer.parseInt(tokens[3]);

                    if (startSectionPirateShip >= 0 && endSectionPirateShip <= pirateShip.length - 1) {
                        for (int i = 0; i <= endSectionPirateShip; i++) {
                            pirateShip[i] -= damageWarShip;
                            if (pirateShip[i] < 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                stalemate = false;
                                break;
                            }
                        }
                    }
                    break;
                case "Repair":
                    //•    Repair {index} {health}
                    int sctnRepairPrtShp = Integer.parseInt(tokens[1]);
                    int addHealthPrtShipSctn = Integer.parseInt(tokens[2]);

                    if (sctnRepairPrtShp >= 0 && sctnRepairPrtShp <= pirateShip.length - 1) {
                        pirateShip[sctnRepairPrtShp] += addHealthPrtShipSctn;
                        if (pirateShip[sctnRepairPrtShp] > maxHealthCapacityPerSection) {
                            pirateShip[sctnRepairPrtShp] = maxHealthCapacityPerSection;
                        }
                    }
                    break;
                case "Status":
                    //•    Status
                    double minimumHealthAllowed = 0.2 * maxHealthCapacityPerSection;
                    int counter = 0;
                    for (int i = 0; i <= pirateShip.length - 1; i++) {
                        if (pirateShip[i] < minimumHealthAllowed) {
                            counter++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", counter);
                    break;
            }
            input = scanner.nextLine();
        }

        int sumPirateShipSections = 0;
        int sumWarShipSections = 0;
        if (stalemate) {

            for (int i = 0; i <= pirateShip.length - 1; i++) {
                sumPirateShipSections = sumPirateShipSections + pirateShip[i];
            }

            for (int i = 0; i <= warShip.length - 1; i++) {
                sumWarShipSections = sumWarShipSections + warShip[i];
            }
        }
        if (stalemate) {
            System.out.println("Pirate ship status: " + sumPirateShipSections);
            System.out.println("Warship status: " + sumWarShipSections);
        }
    }
}
























