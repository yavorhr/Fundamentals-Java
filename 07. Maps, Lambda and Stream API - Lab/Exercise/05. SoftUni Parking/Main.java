import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, String> registeredUsers = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "register" -> {
                    String licensePlateNumber = tokens[2];

                    if (doesUserKeyExist(registeredUsers, username)) {
                        String alreadyRegisteredPlateNumber = registeredUsers.get(username);
                        System.out.printf("ERROR: already registered with plate number %s\n", alreadyRegisteredPlateNumber);
                    } else {
                        registeredUsers.put(username, licensePlateNumber);
                        System.out.printf("%s registered %s successfully\n", username, licensePlateNumber);
                    }
                }
                case "unregister" -> {
                    if (!doesUserKeyExist(registeredUsers, username)) {
                        System.out.printf("ERROR: user %s not found\n", username);
                    } else {
                        registeredUsers.remove(username);
                        System.out.printf("%s unregistered successfully\n", username);
                    }
                }
            }
        }
        printResult(registeredUsers);
    }

    private static boolean doesUserKeyExist(HashMap<String, String> registeredUsers, String username) {
        return registeredUsers.containsKey(username);
    }

    private static void printResult(HashMap<String, String> registeredUsers) {
        for (Map.Entry<String, String> entrySet : registeredUsers.entrySet()) {
            System.out.printf("%s => %s\n", entrySet.getKey(), entrySet.getValue());
        }
    }
}




