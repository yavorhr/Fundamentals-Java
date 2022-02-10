import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> followers = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"Log out".equals(input)) {

            String[] tokens = input.split(": ");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "New follower":
                    followers.putIfAbsent(username, 0);
                    break;
                case "Like":
                    int count = Integer.parseInt(tokens[2]);

                    if (followers.containsKey(username)) {
                        int currentCount = followers.get(username);
                        followers.put(username, currentCount + count);
                    } else {
                        followers.putIfAbsent(username, count);
                    }
                    break;
                case "Comment":
                    if (followers.containsKey(username)) {
                        int currentCount = followers.get(username);
                        followers.put(username, currentCount + 1);
                    } else {
                        followers.putIfAbsent(username, 1);
                    }
                    break;
                case "Blocked":
                    if (followers.containsKey(username)){
                        followers.remove(username);
                    } else {
                        System.out.println(String.format("%s doesn't exist.",username));
                    }

                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(String.format("%d followers", followers.size()));
        followers
                .entrySet()
                .stream()
                .sorted((f1, f2) -> {
                    int result = f2.getValue().compareTo(f1.getValue());
                    if (result == 0) {
                        result = f1.getKey().compareTo(f2.getKey());
                    }
                    return result;
                })
                .forEach(e -> System.out.println(String.format("%s: %d", e.getKey(), e.getValue())));
    }
}







