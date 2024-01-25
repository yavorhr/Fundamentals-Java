import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> followers = new HashMap<>();

        String input = scanner.nextLine();
        while (!"Log out".equals(input)) {
            String[] tokens = input.split(": ");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "New follower" -> followers.putIfAbsent(username, 0);
                case "Like" -> {
                    int count = Integer.parseInt(tokens[2]);

                    if (doesFollowerExist(followers, username)) {
                        int commentsAndLikes = followers.get(username);
                        followers.put(username, commentsAndLikes + count);
                    } else {
                        followers.put(username, count);
                    }
                }
                case "Comment" -> {
                    if (doesFollowerExist(followers, username)) {
                        followers.put(username, followers.get(username) + 1);
                    } else {
                        followers.put(username, 1);
                    }
                }
                case "Blocked" -> {
                    if (!doesFollowerExist(followers, username)) {
                        System.out.printf("%s doesn't exist.\n", username);
                    } else {
                        followers.remove(username);
                    }
                }
            }
            input = scanner.nextLine();
        }

        printResult(followers);
    }

    private static boolean doesFollowerExist(Map<String, Integer> followers, String username) {
        return followers.containsKey(username);
    }

    private static void printResult(Map<String, Integer> followers) {
        StringBuilder sb = new StringBuilder(String.format("%d followers\n", followers.size()));

        followers
                .entrySet()
                .stream()
                .sorted(new ComparatorByLikesCommDescAndByUsername())
                .forEach(e -> sb.append(String.format("%s: %d\n", e.getKey(), e.getValue())));

        System.out.println(sb);
    }
}




