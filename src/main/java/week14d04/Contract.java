/*
Junior
Legyen egy szerződés (Contract) osztály, melynek van egy String client és egy List<Integer> monthlyPrices attribútuma.
Az előbbi a szerződő neve, a második pedig a havonta fizetendő összeg. Legyen egy ContractCreator osztály,
melynek van egy ContractCreator(String client, List<Integer> monthlyPrices) konstruktora, mely létrehoz egy szerződéssablont,
a paraméterként megadott adatokkal, melyet összesen EGY Contract template attribútumban tárolj!

Majd írj egy Contract create(String name) metódust, mely a sablon alapján létrehoz egy új szerződést, de a nevet kicseréli
a paraméterként megadott névre!

Próbáld ki, hogy a visszaadott szerződésben módosítod a 12. havi értéket! Ha létrehozol egy új szerződést a sablon alapján,
akkor a 12 havi érték az eredeti sablon alapján van kitöltve?
 */

package week14d04;

import java.util.ArrayList;
import java.util.List;

public class Contract {

    private String client;

    private List<Integer> monthlyPrices;

    public Contract(String client, List<Integer> monthlyPrices) {
        this.client = client;
        this.monthlyPrices = monthlyPrices;
    }

    public Contract(String client, Contract contract) {             // Copy konstruktor
        this.client = client;                                       // nevet a par-ként átadottra
        monthlyPrices = new ArrayList<>(contract.monthlyPrices);    // átmásolja a par-ként átadott példány mP értékeit egy újabb listába
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public List<Integer> getMonthlyPrices() {
        return monthlyPrices;
    }

    public List<Integer> getMonthlyPricesCopy() {
        return new ArrayList<>(monthlyPrices);   // -> ha itt adnánk vissza a lista másolatát
    }                                            // nem jó, mert akkor beállítani sem lehetne get, set-tel

    public void setMonthlyPrices(List<Integer> monthlyPrices) {
        this.monthlyPrices = monthlyPrices;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "client='" + client + '\'' +
                ", monthlyPrices=" + monthlyPrices +
                '}';
    }
}
