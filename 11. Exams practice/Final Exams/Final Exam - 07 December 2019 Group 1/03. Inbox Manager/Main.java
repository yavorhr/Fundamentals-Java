import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> inboxManager = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            String username = tokens[1];

            List<String> emails = inboxManager.get(username);

            switch (command) {
                case "Add":
                    if (!inboxManager.containsKey(username)) {
                        inboxManager.put(username, new ArrayList<>());
                    } else {
                        System.out.println(String.format("%s is already registered", username));
                    }
                    break;
                case "Send":
                    String currentEmail = tokens[2];
                    emails.add(currentEmail);
                    inboxManager.put(username, emails);
                    break;
                case "Delete":
                    if (inboxManager.containsKey(username)) {
                        inboxManager.remove(username);
                    } else {
                        System.out.println(String.format("%s not found!", username));
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(String.format("Users count: %d", inboxManager.size()));
        inboxManager
                .entrySet()
                .stream()
                .sorted((u1, u2) -> {
                    int result = Integer.compare(u2.getValue().size(), u1.getValue().size());
                    if (result == 0) {
                        result = u1.getKey().compareTo(u2.getKey());
                    }
                    return result;
                })
                .forEach(u -> {
                    System.out.printf("%s%n", u.getKey());
                    u
                            .getValue()
                            .forEach(e -> System.out.println(String.format(" - %s", e)));
                });
    }
}








