package week06d02;

public class Product {
    /*
    Junior
    Hozz létre egy Product osztályt melynek adattagjai a név, kategória és ár, rendre String, String int!
    Készíts egy Store osztályt benne egy Product listával, amit konstruktorban kap meg.
    Legyen egy getProductByCategoryName(Category), ami visszaadja,
    hogy a paraméterül kapott kategóriából hány darab van a listában!
    Bónusz: A kategória legyen enum FROZEN, DAIRY, BAKEDGOODS, OTHER felsorolókkal!
     */

    private String name;
    private String category;
    private int price;

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getPrice() {
        return price;
    }
}
