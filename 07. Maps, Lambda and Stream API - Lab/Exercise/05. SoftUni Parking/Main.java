import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> registered = new LinkedHashMap<>();

        int commandsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commandsCount; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            if (command.equals("register")) {
                String name = tokens[1];
                String licensePlateNumber = tokens[2];

                if (registered.containsKey(name)) {
                    System.out.println(String.format("ERROR: already registered with plate number %s", licensePlateNumber));
                } else {
                    registered.put(name, licensePlateNumber);
                    System.out.println(String.format("%s registered %s successfully", name, licensePlateNumber));
                }
            } else if (command.equals("unregister")) {
                String name = tokens[1];
                if (registered.containsKey(name)) {
                    registered.remove(name);
                    System.out.println(String.format("%s unregistered successfully", name));
                } else {
                    System.out.println(String.format("ERROR: user %s not found", name));
                }
            }
        }

        for (Map.Entry<String, String> entry : registered.entrySet()) {
            System.out.println(String.format("%s => %s", entry.getKey(), entry.getValue()));
        }

    }
}

