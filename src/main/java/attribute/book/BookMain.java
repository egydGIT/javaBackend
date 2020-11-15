package attribute.book;

public class BookMain {
    public static void main(String[] args) {
        Book book = new Book("Programozás gyerekeknek");
        System.out.println(book.getTitle());

        Book book2 = new Book("Kraftolók kézikönyve");
        book2.setTitle("Kraftolók kézikönyve 2.");
        System.out.println(book2.getTitle());



    }
}
