import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> healthMap = new HashMap<>();
        Map<String, Integer> energyMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!"Results".equals(input)) {
            String[] tokens = input.split(":");
            String command = tokens[0];

            switch (command) {
                case "Add" -> {
                    String personName = tokens[1];
                    int healthInput = Integer.parseInt(tokens[2]);
                    int energyInput = Integer.parseInt(tokens[3]);

                    energyMap.putIfAbsent(personName, energyInput);

                    if (healthMap.containsKey(personName)) {
                        updateCurrentHealth(healthMap, personName, healthInput);
                    } else {
                        healthMap.put(personName, healthInput);
                    }
                }
                case "Attack" -> {
                    String attackerName = tokens[1];
                    String defenderName = tokens[2];
                    int damage = Integer.parseInt(tokens[3]);

                    if (energyMap.containsKey(attackerName) && healthMap.containsKey(defenderName)) {

                        int defendersHealth = healthMap.get(defenderName);
                        defendersHealth -= damage;

                        if (defendersHealth <= 0) {
                            disqualifyHero(healthMap, energyMap, defenderName);
                            System.out.printf("%s was disqualified!\n", defenderName);
                        } else {
                            healthMap.put(defenderName, defendersHealth);
                        }

                        int attackerEnergy = energyMap.get(attackerName);
                        attackerEnergy -= 1;

                        if (attackerEnergy == 0) {
                            disqualifyHero(healthMap, energyMap, attackerName);
                            System.out.printf("%s was disqualified!\n", attackerName);
                        } else {
                            energyMap.put(attackerName, attackerEnergy);
                        }
                    }
                }
                case "Delete" -> {
                    String deleteCriteria = tokens[1];

                    if (deleteCriteria.equals("All")) {
                        energyMap.clear();
                        healthMap.clear();
                    } else if (healthMap.containsKey(deleteCriteria)) {
                        disqualifyHero(healthMap, energyMap, deleteCriteria);
                    }
                }
            }
            input = scanner.nextLine();
        }

        System.out.printf("People count: %d\n", healthMap.size());

        healthMap.entrySet().stream().sorted((h1, h2) -> {
            int result = Integer.compare(h2.getValue(), h1.getValue());

            if (result == 0) {
                result = h1.getKey().compareTo(h2.getKey());
            }
            return result;
        }).forEach(h -> System.out.printf("%s - %d - %d\n", h.getKey(), h.getValue(), energyMap.get(h.getKey())));
    }

    private static void disqualifyHero(Map<String, Integer> healthMap, Map<String, Integer> energyMap, String defenderName) {
        energyMap.remove(defenderName);
        healthMap.remove(defenderName);
    }

    private static void updateCurrentHealth(Map<String, Integer> personsHealth, String personName, int healthInput) {
        int currentHealth = personsHealth.get(personName);
        personsHealth.put(personName, currentHealth + healthInput);
    }
}

