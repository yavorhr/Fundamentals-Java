import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Tavern tavern = new Tavern();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String name = tokens[1];

            switch (command) {
                case "Enroll" -> {
                    if (tavern.heroExists(name)) {
                        printErrorMessage(name, " Stefan is already enrolled");
                    } else {
                        tavern.enroll(new Hero(name));
                    }
                }
                case "Unlearn" -> {
                    String spellName = tokens[2];

                    if (tavern.heroExists(name)) {
                        Hero hero = tavern.findHero(name);
                        hero.unlearn(spellName);
                        tavern.updateTavern(hero);
                    } else {
                        printErrorMessage(name, " doesn't exist.");
                    }
                }
                case "Learn" -> {
                    String spellName = tokens[2];

                    if (tavern.heroExists(name)) {
                        Hero hero = tavern.findHero(name);
                        hero.learn(spellName);
                        tavern.updateTavern(hero);
                    } else {
                        printErrorMessage(name, " doesn't exist.");
                    }
                }
            }
            input = scanner.nextLine();
        }

        System.out.println(tavern);
    }

    private static void printErrorMessage(String name, String msg) {
        System.out.printf("%s %s\n", name, msg);
    }
}




