package week05d04;

import java.time.LocalDate;

public class Product {

    /*
    Junior
    Készíts egy Product osztályt melyben egy termékről tárolod a nevét és a lejárati dátumát (LocalDate)!
    Legyen egy konstruktora, ami a nevet kapja meg illetve a lejárati dátumot
    három részletben int year, int month, int day (public Product(String name, int year, int month, int day))!
    A lejárati dátumot a konstruktorban állítsd össze!
    Legyen mindkettőhöz getter metódus!

    Készíts egy Store osztályt, melyben van egy Product-okat tároló lista.
    Legyen benne egy addProduct(Product) metódus!

    Bónusz: Legyen benne egy getNumberOfExpired() metódus ami visszaadja a lejárt termékek számát!
    Használd a LocalDate.now() és az isBefore() metódusokat!
     */

    private String name;

    private LocalDate bestBefore;

    public Product(String name,  int year, int month, int day) {
        this.name = name;
        this.bestBefore = LocalDate.of(year, month, day);
    }


    public String getName() {
        return name;
    }

    public LocalDate getBestBefore() {
        return bestBefore;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", bestBefore=" + bestBefore +
                '}';
    }
}
