package classsctructureintegrate;

public class ProductMain {
    public static void main(String[] args) {
        Product product = new Product("laptop",300000);
        System.out.println(product.getName());
        System.out.println(product.getPrice());

        System.out.println("Akció: 20% kedvezmény minden laptopra!");
        int newPrice = product.decreasePrice(20);
        System.out.println("Régi ár: " + price + "Akciós ár: " + newPrice );

    }
}
