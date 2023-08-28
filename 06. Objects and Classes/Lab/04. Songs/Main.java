import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Song> songList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("_");
            addSongToList(songList, tokens);
        }

        String playListInput = scanner.nextLine();
        printResult(songList, playListInput);
    }

    private static void printResult(List<Song> songList, String playListInput) {
        songList.stream()
                .filter(s -> s.getTypeList().equals(playListInput))
                .forEach(s -> System.out.println(s.getName()));

        if (playListInput.equals("all")){
            songList.forEach(s -> System.out.println(s.getName()));
        }
    }

    private static void addSongToList(List<Song> songList, String[]tokens) {
        String playList = getString(tokens, 0);
        String name = getString(tokens, 1);
        String time = getString(tokens, 2);

        Song currentSong = new Song(name, time, playList);
        songList.add(currentSong);
    }

    private static String getString(String[] tokens, int index) {
        return tokens[index];
    }
}


