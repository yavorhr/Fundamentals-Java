import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> pieceComposerMap = new LinkedHashMap<>();
        Map<String, String> keyAndPieceMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\|");
            String piece = tokens[0];
            String composer = tokens[1];
            String key = tokens[2];

            pieceComposerMap.putIfAbsent(piece, composer);
            keyAndPieceMap.putIfAbsent(piece, key);
        }

        String input = scanner.nextLine();
        while (!"Stop".equals(input)) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];
            String piece = tokens[1];

            switch (command) {
                case "Add":
                    String composer = tokens[2];
                    String key = tokens[3];
                    if (pieceComposerMap.containsKey(piece) && keyAndPieceMap.containsKey(piece)) {
                        System.out.println(String.format("%s is already in the collection!", piece));
                    } else {
                        pieceComposerMap.put(piece, composer);
                        keyAndPieceMap.put(piece, key);
                        System.out.println(String.format("%s by %s in %s added to the collection!", piece, composer, key));
                    }
                    break;

                case "Remove":
                    if (pieceComposerMap.containsKey(piece) && keyAndPieceMap.containsKey(piece)) {
                        pieceComposerMap.remove(piece);
                        keyAndPieceMap.remove(piece);
                        System.out.println(String.format("Successfully removed %s!", piece));
                    } else {
                        System.out.println(String.format("Invalid operation! %s does not exist in the collection.", piece));
                    }
                    break;

                case "ChangeKey":
                    String newKey = tokens[2];
                    if (pieceComposerMap.containsKey(piece) && keyAndPieceMap.containsKey(piece)) {
                        keyAndPieceMap.put(piece, newKey);
                        System.out.println(String.format("Changed the key of %s to %s!", piece, newKey));
                    } else {
                        System.out.println(String.format("Invalid operation! %s does not exist in the collection.", piece));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        pieceComposerMap
                .entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int result = p1.getKey().compareTo(p2.getKey());
                    if (result == 0) {
                        result = p1.getValue().compareTo(p2.getValue());
                        return result;
                    }
                    return result;
                }).forEach(entry -> System.out.println(String.format("%s -> Composer: %s, Key: %s",entry.getKey(),entry.getValue(),keyAndPieceMap.get(entry.getKey()))));
    }
}


