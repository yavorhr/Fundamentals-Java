import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Hero> heroes = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String input = scanner.nextLine();
            addHeroToList(input, heroes);
        }


        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];

            switch (command) {
                case "Heal" -> {
                    int hp = Integer.parseInt(tokens[2]);

                    Hero currentHero = heroes.get(heroName);
                    currentHero.heal(hp);
                    heroes.put(heroName, currentHero);
                }
                case "Recharge" -> {
                    int mp = Integer.parseInt(tokens[2]);

                    Hero currentHero = heroes.get(heroName);
                    currentHero.recharge(mp);
                    heroes.put(heroName, currentHero);
                }
                case "TakeDamage" -> {
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];

                    Hero currentHero = heroes.get(heroName);
                    boolean heroIsKilled = currentHero.takeDamage(damage, attacker);

                    if (heroIsKilled) {
                        heroes.remove(heroName);
                    }
                }
                case "CastSpell" -> {
                    int mana = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];

                    Hero currentHero = heroes.get(heroName);
                    currentHero.castSpell(mana, spellName);
                    heroes.put(heroName, currentHero);
                }
            }
            input = scanner.nextLine();
        }
        printResult(heroes);
    }

    private static void printResult(Map<String, Hero> heroes) {
        StringBuilder sb = new StringBuilder();
        heroes.values().stream().sorted().forEach(h -> {
            sb.append(String.format("""
                    %s
                      HP: %d
                      MP: %d
                    """, h.getName(), h.getHealth(), h.getMana()));
        });

        System.out.println(sb.toString());
    }

    private static void addHeroToList(String input, Map<String, Hero> heroes) {
        String[] heroTokens = input.split(" ");
        String name = heroTokens[0];
        int hp = Integer.parseInt(heroTokens[1]);
        int mana = Integer.parseInt(heroTokens[2]);

        heroes.put(name, new Hero(name, hp, mana));
    }
}




