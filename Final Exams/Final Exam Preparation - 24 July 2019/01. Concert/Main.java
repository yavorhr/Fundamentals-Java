import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> bandsMembers = new LinkedHashMap<>();
        Map<String, Integer> playTime = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"start of concert".equals(input)) {
            String[] tokens = input.split("; ");
            String command = tokens[0];
            String bandName = tokens[1];

            switch (command) {
                case "Add":
                    String[] members = tokens[2].split(", ");
                    bandsMembers.putIfAbsent(bandName, new ArrayList<>());

                    List<String> currentMembers = bandsMembers.get(bandName);
                    for (int i = 0; i < members.length; i++) {
                        if (!currentMembers.contains(members[i])) {
                            currentMembers.add(members[i]);
                        }
                    }
                    bandsMembers.put(bandName, currentMembers);
                    break;
                case "Play":
                    int time = Integer.parseInt(tokens[2]);
                    playTime.putIfAbsent(bandName, 0);
                    int oldTime = playTime.get(bandName);
                    playTime.put(bandName, oldTime + time);
                    break;
            }
            input = scanner.nextLine();
        }

        int sum = 0;
        for (Map.Entry<String, Integer> entry : playTime.entrySet()) {
            sum += entry.getValue();
        }

        System.out.println(String.format("Total time: %d", sum));
        playTime
                .entrySet()
                .stream()
                .sorted((b1, b2) -> {
                    int result = b2.getValue().compareTo(b1.getValue());
                    if (result == 0) {
                        result = b1.getKey().compareTo(b2.getKey());
                    }
                    return result;
                }).forEach(e -> {
            System.out.println(String.format("%s -> %d", e.getKey(), e.getValue()));
        });
        String printBand = scanner.nextLine();
        System.out.println(printBand);
        List<String> memebers = bandsMembers.get(printBand);

        for (String memeber : memebers) {
            System.out.println(String.format("=> %s",memeber));
        }

    }
}













