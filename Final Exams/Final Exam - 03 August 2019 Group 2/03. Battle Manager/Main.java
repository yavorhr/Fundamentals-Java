import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> healthmap = new HashMap<>();
        Map<String, Integer> energyMap = new HashMap<>();

        String input = scanner.nextLine();
        while (!"Results".equals(input)) {
            String[] tokens = input.split(":");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String personName = tokens[1];
                    int healthToAdd = Integer.parseInt(tokens[2]);
                    int energyToAdd = Integer.parseInt(tokens[3]);

                    if (!healthmap.containsKey(personName)) {
                        healthmap.put(personName, healthToAdd);
                        energyMap.put(personName, energyToAdd);
                    } else {
                        healthmap.put(personName, healthmap.get(personName) + healthToAdd);
                    }
                    break;
                case "Attack":
                    String attacker = tokens[1];
                    String defender = tokens[2];
                    int damage = Integer.parseInt(tokens[3]);

                    if (healthmap.containsKey(attacker) && healthmap.containsKey(defender)) {
                        int healthDefender = healthmap.get(defender);
                        int energyAttacker = energyMap.get(attacker);

                        if (healthDefender - damage > 0) {
                            healthmap.put(defender, healthDefender - damage);
                        } else {
                            healthmap.remove(defender);
                            energyMap.remove(defender);
                            System.out.println(String.format("%s was disqualified!", defender));
                        }

                        if (energyAttacker - 1 > 0) {
                            energyMap.put(attacker, energyAttacker - 1);
                        } else {
                            healthmap.remove(attacker);
                            energyMap.remove(attacker);
                            System.out.println(String.format("%s was disqualified!", attacker));
                        }
                    }
                    break;
                case "Delete":
                    String username = tokens[1];
                    if (username.equals("All")) {
                        energyMap.clear();
                        healthmap.clear();
                    } else {
                        energyMap.remove(username);
                        healthmap.remove(username);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println(String.format("People count: %d", healthmap.size()));

        healthmap
                .entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int result = p2.getValue().compareTo(p1.getValue());
                    if (result == 0) {
                        result = p1.getKey().compareTo(p2.getKey());
                    }
                    return result;
                }).forEach(e -> System.out.println(String.format("%s - %d - %d", e.getKey(), e.getValue(), energyMap.get(e.getKey()))));
    }
}











