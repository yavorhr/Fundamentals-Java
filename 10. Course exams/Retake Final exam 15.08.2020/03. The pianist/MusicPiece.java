public class MusicPiece implements Comparable<MusicPiece> {
    private String name;
    private String author;
    private String key;

    public MusicPiece(String name, String author, String key) {
        this.name = name;
        this.author = author;
        this.key = key;
    }

    public void changeKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    @Override
    public int compareTo(MusicPiece otherPiece) {
        int result = this.name.compareTo(otherPiece.getName());
        if (result == 0) {
            result = this.key.compareTo(otherPiece.getKey());
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s -> Composer: %s, Key: %s", this.name, this.author, this.key);
    }
}
