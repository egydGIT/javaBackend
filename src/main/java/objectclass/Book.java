package objectclass;

public class Book {

    String author;
    String title;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        return title != null ? title.equals(book.title) : book.title == null;
    }

    @Override
    public int hashCode() {
        int result = author.hashCode();
        result = 31 * result + title.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Book: " + author + " / " + title;
    }

    public static void main(String[] args) {
        SimpleBag simpleBag = new SimpleBag();
        Book book1 = new Book("Kövesdán Gábor", "Szoftverfejlesztés Java SE platformon");
        Book book2 = new Book("CAROL VORDERMAN".toLowerCase(), "Programozás gyerekeknek - scratch játékok lépésről lépésre");
        Book book3 = new Book("Barry Burd", "Java");
        simpleBag.putItem(book1);
        simpleBag.putItem(book2);
        simpleBag.putItem(book3);

        System.out.println(simpleBag.getItems());
        System.out.println(simpleBag.size());
        System.out.println(simpleBag.hasNext());
        System.out.println(simpleBag.contains(book2));
        System.out.println(simpleBag.getCursor());
        System.out.println(simpleBag.next());
        System.out.println(simpleBag.next());
        System.out.println(simpleBag.next());
        System.out.println(simpleBag.hasNext());
        System.out.println(simpleBag.getCursor());
        // System.out.println(simpleBag.beforeFirst());


    }
}
