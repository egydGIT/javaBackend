package week14d04;

import java.util.ArrayList;
import java.util.List;

public class ContractCreator {

    private Contract template;                                              // sablon

    public ContractCreator(String client, List<Integer> monthlyPrices) {    // sablon szerződés példányosítása
        template = new Contract(client, monthlyPrices);
    }

    public Contract create(String client) {                             // sablon alapján hoz létre új szerződést
        return new Contract(client, template.getMonthlyPrices());       // nevet felülírja, havi díjjat a sablonból átmásolja
    }           // DE! így minden új példány ugyanarra a listára hivatkozik

    public Contract createCopy(String client) {
        return new Contract(client, new ArrayList<>(template.getMonthlyPrices())); // -> ArrayList copy konstruktora
    }           // sablon lista másolatát adja vissza

    public Contract createWithCopyConstructor(String client) {
        return new Contract(client, template);          // létrejön egy új contract egy másik contract alapján
    }

    public static void main(String[] args) {
        ContractCreator cc = new ContractCreator("Model Name",
                new ArrayList<>(List.of(10, 10, 10)));
        Contract contract1 = cc.create("John Doe");
        Contract contract2 = cc.create("Jack Doe");

        System.out.println(contract1); // Contract{client='John Doe', monthlyPrices=[10, 10, 10]}
        System.out.println(contract2); // Contract{client='Jack Doe', monthlyPrices=[10, 10, 10]}

        // ugyanarra az obj-ra hivatkoznak:
        contract1.getMonthlyPrices().set(1, 20);    // List.of() immutable -> UnsupportedOperationException
                                                    // new ArrayList<>(List.of()); -> új mutable listába másolja az immutable-t
                // egyik példányon keresztül módosítjuk a havidíjjat, de minden pld ugyanarra a listára hivatkozik

        System.out.println(contract1); // Contract{client='John Doe', monthlyPrices=[10, 20, 10]}
        System.out.println(contract2); // Contract{client='Jack Doe', monthlyPrices=[10, 20, 10]}

        Contract contract3 = cc.create("Jane Doe");
        System.out.println(contract3); // Contract{client='Jane Doe', monthlyPrices=[10, 20, 10]}
                // -> az összes új példánynak módosult a szerz-e


        // ArrayList másolatára hivatkoznak:
        System.out.println("createCopy()");

        Contract contract1b = cc.createCopy("John Doe");
        Contract contract2b = cc.createCopy("Jack Doe");
        System.out.println(contract1b); // Contract{client='John Doe', monthlyPrices=[10, 20, 10]}
        System.out.println(contract2b); // Contract{client='Jack Doe', monthlyPrices=[10, 20, 10]}

        contract1b.getMonthlyPrices().set(1, 30);
        System.out.println(contract1b); // Contract{client='John Doe', monthlyPrices=[10, 30, 10]}
        System.out.println(contract2b); // Contract{client='Jack Doe', monthlyPrices=[10, 20, 10]}


        // getMonthlyPricesCopy();
        System.out.println("getMonthlyPricesCopy()");

        Contract contract1c = cc.create("John Doe");
        contract1c.getMonthlyPricesCopy().set(1, 30);
        System.out.println(contract1c);                 // Contract{client='John Doe', monthlyPrices=[10, 20, 10]}

        Contract contract1d = cc.createCopy("John Doe");
        contract1d.getMonthlyPricesCopy().set(1, 30);
        System.out.println(contract1d);                 // Contract{client='John Doe', monthlyPrices=[10, 20, 10]}

        // createWithCopyConstructor()
        System.out.println("createWithCopyConstructor()");
        Contract contract1e = cc.createWithCopyConstructor("John Doe");
        contract1e.getMonthlyPrices().set(1, 40);
        System.out.println(contract1e);                 // Contract{client='John Doe', monthlyPrices=[10, 40, 10]}


    }

}
