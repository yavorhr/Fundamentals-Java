public class Song {
    private String name;
    private String time;
    private String typeList;

    public Song(String name, String time, String typeList) {
        this.name = name;
        this.time = time;
        this.typeList = typeList;
    }

    public String getName() {
        return this.name;
    }

    public String getTime() {
        return this.time;
    }

    public String getTypeList() {
        return this.typeList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Song setTime(String time) {
        this.time = time;
        return this;
    }

    public Song setTypeList(String typeList) {
        this.typeList = typeList;
        return this;
    }
}
