package week02;

import java.util.Scanner;

public class Product {
    private String name;

    private String code;

    public Product() {
        this.name = name;
        this.code = code;
    }

    public void areTheyEqual(String compare, String compareWith) {
        compare.equals(compareWith); {
            if (true) {
                System.out.println("A két termék megegyezik.");
            }
        }
    }


    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product();

        String name1 = "laptop 0123";
        String name2 = "laptop 4567";
        String name3 = "laptop 8910";
        String name4 = "laptop 0123";

        System.out.println(name1);
        System.out.println(name2);
        System.out.println(name3);
        System.out.println(name4);
        System.out.println("");

        System.out.println("Compare: ");
        String compare = scanner.nextLine();

        System.out.println("Compare with: ");
        String compareWith = scanner.nextLine();

        // product.areTheyEqual();



    }


}
