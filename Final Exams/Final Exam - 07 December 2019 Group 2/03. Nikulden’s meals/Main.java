import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> nikulden = new LinkedHashMap<>();

        List<String> unlikedMeals = new ArrayList<>();


        String input = scanner.nextLine();
        while (!"Stop".equals(input)) {
            String[] tokens = input.split("-");
            String command = tokens[0];
            String guest = tokens[1];
            String currentMeal = tokens[2];

            switch (command) {
                case "Like":
                    if (!nikulden.containsKey(guest)) {
                        nikulden.put(guest, new ArrayList<>());
                        List<String> guestMeals = nikulden.get(guest);
                        guestMeals.add(currentMeal);
                        nikulden.put(guest, guestMeals);
                    } else {
                        List<String> guestMeals = nikulden.get(guest);
                        if (!guestMeals.contains(currentMeal)) {
                            guestMeals.add(currentMeal);
                            nikulden.put(guest, guestMeals);
                        } else {
                            break;
                        }
                    }
                    break;
                case "Unlike":
                    if (!nikulden.containsKey(guest)) {
                        System.out.println(String.format("%s is not at the party.", guest));
                        break;
                    } else {
                        List<String> guestMeals = nikulden.get(guest);
                        if (!guestMeals.contains(currentMeal)) {
                            System.out.println(String.format("%s doesn't have the %s in his/her collection.", guest, currentMeal));
                        } else {
                            guestMeals.remove(currentMeal);
                            nikulden.put(guest, guestMeals);

                            if (!unlikedMeals.contains(guest)) {
                                unlikedMeals.add(guest);
                            }
                            System.out.println(String.format("%s doesn't like the %s.", guest, currentMeal));
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }


        nikulden
                .entrySet()
                .stream()
                .sorted((m1, m2) -> {
                    int result = Integer.compare(m2.getValue().size(), m1.getValue().size());
                    if (result == 0) {
                        result = m1.getKey().compareTo(m2.getKey());
                    }
                    return result;
                }).forEach(entry -> System.out.println(String.format("%s: %s", entry.getKey(),
                String.join(", ", entry.getValue()))));


        System.out.printf("Unliked meals: %d", unlikedMeals.size());
    }
}




