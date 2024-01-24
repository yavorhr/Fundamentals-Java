import java.util.ArrayList;
import java.util.List;

public class Band {
    private String name;
    private List<String> members;
    private int playTime;

    public Band(String name) {
        this.name = name;
        this.members = new ArrayList<>();
        this.playTime = 0;
    }

    public int getPlayTime() {
        return playTime;
    }

    public List<String> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    public void add(String name) {
        if (!this.members.contains(name))
            this.members.add(name);
    }

    public void play(int minutes) {
        playTime += minutes;
    }

    @Override
    public String toString() {
        return String.format("%s -> %d\n", this.name, this.playTime);
    }
}
