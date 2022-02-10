import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> heroes = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String currentHero = tokens[1];

            switch (command) {
                case "Enroll":
                    if (heroes.containsKey(currentHero)) {
                        System.out.printf("%s is already enrolled.%n", currentHero);
                    } else {
                        heroes.putIfAbsent(currentHero, new ArrayList<>());
                    }
                    break;
                case "Learn":
                    String spellName = tokens[2];

                    if (!heroes.containsKey(currentHero)) {
                        System.out.printf("%s doesn't exist.%n", currentHero);
                        break;
                    }

                    List<String> currentSpells = heroes.get(currentHero);
                    if (currentSpells.contains(spellName)) {
                        System.out.printf("%s has already learnt %s.%n", currentHero, spellName);
                    } else {
                        List<String> addSpells = heroes.get(currentHero);
                        addSpells.add(spellName);
                        heroes.put(currentHero, addSpells);
                    }
                    break;
                case "Unlearn":
                    spellName = tokens[2];
                    if (!heroes.containsKey(currentHero)) {
                        System.out.printf("%s doesn't exist.%n", currentHero);
                        break;
                    }

                    List<String> spellsList = heroes.get(currentHero);
                    if (!spellsList.contains(spellName)) {
                        System.out.println(String.format("%s doesn't know %s.", currentHero, spellName));
                        break;
                    } else {
                        spellsList.remove(spellName);
                        heroes.put(currentHero, spellsList);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Heroes:");
        heroes
                .entrySet()
                .stream()
                .sorted((h1, h2) -> {
                    int result = Integer.compare(h2.getValue().size(), h1.getValue().size());
                    if (result == 0) {
                        result = h1.getKey().compareTo(h2.getKey());
                    }
                    return result;
                })
                .forEach(entry -> {
                    System.out.printf("== %s: ", entry.getKey());
                    System.out.printf("%s", String.join(", ", entry.getValue()));
                    System.out.println();
                });
    }
}



