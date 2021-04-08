package classstructureintegrate;

import java.util.Scanner;

public class ProductMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Add meg a termék nevét!");
        String name = scanner.nextLine();

        System.out.println("Add meg a termék árát!");
        int price = scanner.nextInt();

        System.out.println("Add meg az akció százalékát!");
        int perCent = scanner.nextInt();

        Product product = new Product(name, price);

        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(perCent + " %");

        System.out.println("Akció: " + perCent + " % kedvezmény minden " + product.getName() + " árából!");
        System.out.println("Akciós ár: " + product.decreasePrice(perCent));

    }
}

