import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static class Songs {
        private String typeList;
        private String name;
        private String time;

        public Songs(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getTypeList() {
            return this.typeList;
        }

        public String getName() {
            return this.name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Songs> playlist = new ArrayList<>();

        int countSongs = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countSongs; i++) {
            String[] data = scanner.nextLine().split("_");
            String typeList = data[0];
            String name = data[1];
            String time = data[2];

            Songs currentSong = new Songs(typeList, name, time);
            playlist.add(currentSong);
        }

        String shuffle = scanner.nextLine();

        for (Songs song : playlist) {
            if (shuffle.equals("all")) {
                System.out.println(song.getName());
            } else if (shuffle.equals(song.getTypeList())) {
                System.out.println(song.getName());
            }
        }

    }
}














