package week02d03;

import java.util.Scanner;

public class Product {
    /*
    2020-11-04 (week02d03)
        Írj egy Product oszályt String name és String code attribútumokkal!
        Legyen egy konstruktora a két attribútummal!
        Legyen egy areTheyEqual() metódusa, mely kap egy másik Product példányt, és eldönti, hogy azonos-e az adott példánnyal.
        Két termék akkor egyezik, ha a nevük megegyezik.

        Bónusz: szigorúbb egyelőség a feltételre: a két termék kódjának hosszának különbsége maximum egy karakter lehet.
     */

    private String name;
    private String code;

    public Product(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public boolean areTheyEqual(Product newProduct) {
        if (this.getName().trim().equals(newProduct.getName().trim())) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. termék neve: ");
        String name1 = scanner.nextLine();
        System.out.println("1. termék kódja: ");
        String code1 = scanner.nextLine();
        Product product1 = new Product(name1, code1);

        System.out.println("2. termék neve: ");
        String name2 = scanner.nextLine();
        System.out.println("2. termék kódja: ");
        String code2 = scanner.nextLine();
        Product product2 = new Product(name2, code2);

        System.out.println("3. termék neve: ");
        String name3 = scanner.nextLine();
        System.out.println("3. termék kódja: ");
        String code3 = scanner.nextLine();
        Product product3 = new Product(name3, code3);

        System.out.println("Megegyeznek: " + product1.getName().trim() + " " + product2.getName().trim());
        System.out.println(product1.areTheyEqual(product2));
        System.out.println("Megegyeznek: " + product2.getName().trim() + " "  + product3.getName().trim());
        System.out.println(product2.areTheyEqual(product3));

    }
}
