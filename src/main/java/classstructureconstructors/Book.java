package classstructureconstructors;

public class Book {
    private String author;
    private String tittle;
    private String regNumber;

    public Book(String author, String tittle) {
        this.author = author;
        this.tittle = tittle;
    }

    public void register(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getAuthor() {
        return author;
    }

    public String getTittle() {
        return tittle;
    }

    public String getRegNumber() {
        return regNumber;
    }
}
