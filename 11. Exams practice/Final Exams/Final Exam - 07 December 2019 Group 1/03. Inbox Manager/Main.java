import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> users = new HashMap<>();

        String input = scanner.nextLine();
        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("->");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "Add" -> {
                    if (doesUserExist(users, username)) {
                        printErrorMessage(username, " is already registered\n");
                    } else {
                        users.put(username, new ArrayList<>());
                    }
                }
                case "Send" -> {
                    String email = tokens[2];

                    if (doesUserExist(users, username)) {
                        addEmail(users, username, email);
                    }
                }
                case "Delete" -> {
                    if (doesUserExist(users, username)) {
                        users.remove(username);
                    } else {
                        printErrorMessage(username, " not found!\n");
                    }
                }
            }
            input = scanner.nextLine();
        }

        printUsersMap(users);
    }

    private static void addEmail(Map<String, List<String>> users, String username, String email) {
        List<String> currentEmails = users.get(username);
        currentEmails.add(email);
        users.put(username, currentEmails);
    }

    private static void printUsersMap(Map<String, List<String>> users) {
        StringBuilder sb = new StringBuilder(String.format("Users count: %d\n", users.size()));

        users
                .entrySet()
                .stream()
                .sorted((u1, u2) -> {
                    int result = u2.getValue().size() - u1.getValue().size();
                    if (result == 0) {
                        result = u1.getKey().compareTo(u2.getKey());
                    }
                    return result;
                }).forEach(user -> {
            sb
                    .append(user.getKey())
                    .append(System.lineSeparator());
            user
                    .getValue()
                    .forEach(email ->
                            sb.append(String.format(" - %s\n", email)));
        });

        System.out.println(sb);
    }

    private static void printErrorMessage(String username, String message) {
        System.out.printf("%s " + "%s", username, message);
    }

    private static boolean doesUserExist(Map<String, List<String>> users, String username) {
        return users.containsKey(username);
    }
}


