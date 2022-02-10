import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> mapHealthPoints = new LinkedHashMap<>();
        Map<String, Integer> mapManaPoints = new LinkedHashMap<>();

        int heroesCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < heroesCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String nameOfHero = tokens[0];
            int healthPoints = Integer.parseInt(tokens[1]);
            int manaPoints = Integer.parseInt(tokens[2]);

            mapHealthPoints.put(nameOfHero, healthPoints);
            mapManaPoints.put(nameOfHero, manaPoints);
        }

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String currentHero = tokens[1];

            switch (command) {
                case "CastSpell":
                    int manaNeeded = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];

                    if (mapManaPoints.get(currentHero) >= manaNeeded) {
                        int newMana = mapManaPoints.get(currentHero) - manaNeeded;
                        mapManaPoints.put(currentHero, newMana);
                        System.out.println(String.format("%s has successfully cast %s and now has %d MP!", currentHero, spellName, newMana));
                    } else {
                        System.out.println(String.format("%s does not have enough MP to cast %s!", currentHero, spellName));
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];

                    if (mapHealthPoints.get(currentHero) - damage > 0) {
                        int newNealthPoints = mapHealthPoints.get(currentHero) - damage;
                        mapHealthPoints.put(currentHero, newNealthPoints);
                        System.out.println(String.format("%s was hit for %d HP by %s and now has %d HP left!", currentHero, damage, attacker, mapHealthPoints.get(currentHero)));
                    } else {
                        mapHealthPoints.remove(currentHero);
                        mapManaPoints.remove(currentHero);
                        System.out.println(String.format("%s has been killed by %s!", currentHero, attacker));
                    }
                    break;
                case "Recharge":
                    int amountMana = Integer.parseInt(tokens[2]);
                    if (mapManaPoints.get(currentHero) + amountMana > 200) {
                        int oldMana = mapManaPoints.get(currentHero);
                        mapManaPoints.put(currentHero,200);
                        System.out.println(String.format("%s recharged for %d MP!",currentHero,200-oldMana));
                    } else {
                        int newMana = mapManaPoints.get(currentHero)+amountMana;
                        mapManaPoints.put(currentHero,newMana);
                        System.out.println(String.format("%s recharged for %d MP!",currentHero,amountMana));
                    }
                    break;
                case "Heal":
                    int amountHealth = Integer.parseInt(tokens[2]);
                    if (mapHealthPoints.get(currentHero) + amountHealth > 100) {
                        int oldHealth = mapHealthPoints.get(currentHero);
                        mapHealthPoints.put(currentHero,100);
                        System.out.println(String.format("%s healed for %d HP!",currentHero,100-oldHealth));
                    } else {
                        int newHealth = mapHealthPoints.get(currentHero)+amountHealth;
                        mapHealthPoints.put(currentHero,newHealth);
                        System.out.println(String.format("%s healed for %d HP!",currentHero,amountHealth));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        mapHealthPoints
                .entrySet()
                .stream()
                .sorted((h1,h2)-> {
                    int result = Integer.compare(h2.getValue(),h1.getValue());
                    if (result==0){
                        result = h1.getKey().compareTo(h2.getKey());
                    }return result;
                }).forEach(h->{
            System.out.println(String.format("%s",h.getKey()));
            System.out.println(String.format("  HP: %d",h.getValue()));
            System.out.println(String.format("  MP: %d",mapManaPoints.get(h.getKey())));
        });
    }
}


