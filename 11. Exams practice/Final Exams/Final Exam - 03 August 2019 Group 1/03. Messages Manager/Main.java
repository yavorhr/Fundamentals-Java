import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int messagesCapacity = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> receivedMessages = new HashMap<>();
        Map<String, Integer> sentMessages = new HashMap<>();

        String input = scanner.nextLine();

        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("=");
            String command = tokens[0];

            switch (command) {
                case "Add" -> {
                    String username = tokens[1];
                    int sentCount = Integer.parseInt(tokens[2]);
                    int receivedCount = Integer.parseInt(tokens[3]);

                    sentMessages.putIfAbsent(username, sentCount);
                    receivedMessages.putIfAbsent(username, receivedCount);
                }
                case "Message" -> {
                    String sender = tokens[1];
                    String receiver = tokens[2];

                    if (doesUserExist(sentMessages, sender) && doesUserExist(receivedMessages, receiver)) {
                        int currentSentMessages = sentMessages.get(sender) + 1;
                        int currentReceivedMessages = receivedMessages.get(receiver) + 1;

                        int sentAndReceivedMessagesSender = getTotalMessages(currentSentMessages, receivedMessages, sender);
                        int sentAndReceivedMessagesReceiver = getTotalMessages(currentReceivedMessages, sentMessages, receiver);

                        if (maxCapacityReached(messagesCapacity, sentAndReceivedMessagesSender)) {
                            removeUser(sentMessages, receivedMessages, sender);
                            System.out.println(sender + " reached the capacity!");
                        } else {
                            sentMessages.put(sender, currentSentMessages);
                        }

                        if (maxCapacityReached(messagesCapacity, sentAndReceivedMessagesReceiver)) {
                            removeUser(receivedMessages, sentMessages, receiver);
                            System.out.println(receiver + " reached the capacity!");
                        } else {
                            receivedMessages.put(receiver, currentReceivedMessages);
                        }
                    }
                }
                case "Empty" -> {
                    String deleteByCriteria = tokens[1];

                    if (deleteByCriteria.equals("All")) {
                        sentMessages.clear();
                        receivedMessages.clear();
                    } else {
                        removeUser(sentMessages, receivedMessages, deleteByCriteria);
                    }
                }
            }

            input = scanner.nextLine();
        }

        System.out.printf("Users count: %d\n", receivedMessages.size());

        receivedMessages.entrySet().stream().sorted((u1, u2) -> {
            int result = Integer.compare(u2.getValue(), u1.getValue());

            if (result == 0) {
                result = u1.getKey().compareTo(u2.getKey());
            }
            return result;
        }).forEach(u -> {
            int totalMessages = u.getValue() + sentMessages.get(u.getKey());
            System.out.printf("%s - %d\n", u.getKey(), totalMessages);
        });

    }

    private static void removeUser(Map<String, Integer> sentMessages, Map<String, Integer> receivedMessages, String sender) {
        sentMessages.remove(sender);
        receivedMessages.remove(sender);
    }

    private static boolean maxCapacityReached(int messagesCapacity, int totalMessagesSender) {
        return totalMessagesSender == messagesCapacity;
    }

    private static boolean doesUserExist(Map<String, Integer> sentMessages, String sender) {
        return sentMessages.containsKey(sender);
    }

    private static int getTotalMessages(int currentMessages, Map<String, Integer> getRestMessages, String user) {
        int otherMessages = getRestMessages.get(user);
        return currentMessages + otherMessages;
    }
}


