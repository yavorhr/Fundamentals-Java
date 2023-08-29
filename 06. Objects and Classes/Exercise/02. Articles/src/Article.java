public class Article {
    private String title;
    private String content;
    private String author;

    public Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void edit(String content) {
        setContent(content);
    }

    public void changeAuthor(String author) {
        setAuthor(author);
    }

    public void rename(String title) {
        setTitle(title);
    }

    public String getTitle() {
        return title;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Article setContent(String content) {
        this.content = content;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public Article setAuthor(String author) {
        this.author = author;
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s - %s:%s", this.title, this.content, this.author);
    }
}
