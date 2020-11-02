package classstructureconstructors;

public class Book {
    private String author;
    private String tittle;
    private int regNumber;

    public Book(String author, String tittle) {
        this.author = author;
        this.tittle = tittle;
    }

    public void register(int regNumber) {
        this.regNumber = regNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getTittle() {
        return tittle;
    }

    public int getRegNumber() {
        return regNumber;
    }
}
