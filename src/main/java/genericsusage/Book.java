package genericsusage;

public class Book {

    private String title;

    private String author;

    private int regNumber;

    public Book() {
    }

    public Book(String title, String author, int regNumber) {
        this.title = title;
        this.author = author;
        this.regNumber = regNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(int regNumber) {
        this.regNumber = regNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", regNumber=" + regNumber +
                '}';
    }
}
