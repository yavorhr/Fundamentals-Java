import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> receivedMessages = new LinkedHashMap<>();
        Map<String, Integer> sentMessages = new LinkedHashMap<>();

        int capacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("=");
            String command = tokens[0];
            String user = tokens[1];

            switch (command) {
                case "Add":
                    int sent = Integer.parseInt(tokens[2]);
                    int received = Integer.parseInt(tokens[3]);

                    if (!receivedMessages.containsKey(user)) {
                        receivedMessages.put(user, received);
                    }

                    if ((!sentMessages.containsKey(user))) {
                        sentMessages.put(user, sent);
                    }

                    break;
                case "Message":
                    String sender = tokens[1];
                    String receiver = tokens[2];

                    if (receivedMessages.containsKey(receiver) && (sentMessages.containsKey(sender))) {
                        sentMessages.put(sender, sentMessages.get(sender) + 1);
                        receivedMessages.put(receiver, receivedMessages.get(receiver) + 1);
                        if (sentMessages.get(sender) + receivedMessages.get(sender) >= capacity) {
                            sentMessages.remove(sender);
                            receivedMessages.remove(sender);
                            System.out.println(String.format("%s reached the capacity!", sender));
                        }

                        if (receivedMessages.get(receiver) + sentMessages.get(receiver) >= capacity) {
                            receivedMessages.remove(receiver);
                            sentMessages.remove(receiver);
                            System.out.println(String.format("%s reached the capacity!", receiver));
                        }
                    }
                    break;
                case "Empty":
                    if ("All".equals(user)) {
                        receivedMessages.clear();
                        sentMessages.clear();
                    } else {
                        receivedMessages.remove(user);
                        sentMessages.remove(user);
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println(String.format("Users count: %d", receivedMessages.size()));
        receivedMessages
                .entrySet()
                .stream()
                .sorted((u1, u2) -> {
                    int result = Integer.compare(u2.getValue(), (u1.getValue()));
                    if (result == 0) {
                        result = u1.getKey().compareTo(u2.getKey());
                    }
                    return result;
                }).forEach(e -> {
            int allMessages = e.getValue() + sentMessages.get(e.getKey());
            System.out.println(String.format("%s - %d", e.getKey(), allMessages));
        });
    }
}













