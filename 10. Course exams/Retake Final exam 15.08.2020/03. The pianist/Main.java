import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, MusicPiece> musicPiecesMap = new HashMap<>();

        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\|");
            addMusicPieceToMap(musicPiecesMap, tokens);
        }

        String input = scanner.nextLine();
        while (!"Stop".equals(input)) {
            String[] tokens = input.split("\\|");
            String command = tokens[0];
            String name = tokens[1];

            switch (command) {
                case "Add" -> {
                    String composer = tokens[2];
                    String key = tokens[3];
                    if (pieceExistsInCollection(musicPiecesMap, name)) {
                        printOutput(String.format("%s is already in the collection!", name));
                    } else {
                        musicPiecesMap.put(name, new MusicPiece(name, composer, key));
                        printOutput(String.format("%s by %s in %s added to the collection!", name, composer, key));
                    }
                }
                case "Remove" -> {
                    if (pieceExistsInCollection(musicPiecesMap, name)) {
                        musicPiecesMap.remove(name);
                        printOutput(String.format("Successfully removed %s!", name));
                    } else {
                        printOutput(String.format("Invalid operation! %s does not exist in the collection.", name));
                    }
                }
                case "ChangeKey" -> {
                    String key = tokens[2];
                    if (!pieceExistsInCollection(musicPiecesMap, name)) {
                        printOutput(String.format("Invalid operation! %s does not exist in the collection.", name));
                    } else {
                        changeKeyOfPiece(musicPiecesMap, name, key);
                        printOutput(String.format("Changed the key of %s to %s!",name,key));
                    }
                }
            }

            input = scanner.nextLine();
        }

        musicPiecesMap.values()
                .stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static void changeKeyOfPiece(Map<String, MusicPiece> musicPiecesMap, String name, String key) {
        MusicPiece musicPiece = musicPiecesMap.get(name);
        musicPiece.changeKey(key);
        musicPiecesMap.put(name, musicPiece);
    }

    private static boolean pieceExistsInCollection(Map<String, MusicPiece> musicPiecesMap, String name) {
        return musicPiecesMap.containsKey(name);
    }

    private static void addMusicPieceToMap(Map<String, MusicPiece> musicPieces, String[] tokens) {
        String name = tokens[0];
        String author = tokens[1];
        String key = tokens[2];

        musicPieces.put(name, new MusicPiece(name, author, key));
    }

    public static void printOutput(String output) {
        System.out.println(output);
    }
}




