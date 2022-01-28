import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> companiesUsers = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" -> ");
            String company = tokens[0];
            String id = tokens[1];

            companiesUsers.putIfAbsent(company, new ArrayList<>());
            List<String> list = companiesUsers.get(company);

            if (!list.contains(id)) {
                list.add(id);
            }

            input = scanner.nextLine();
        }

        companiesUsers
                .entrySet()
                .stream()
                .sorted((c1, c2) -> c1.getKey().compareTo(c2.getKey()))
                .forEach(c -> {
                    System.out.println(c.getKey());
                    c.getValue().forEach(id -> System.out.println(String.format("-- %s", id)));
                });
    }
}


