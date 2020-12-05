package algoritmssum;

import java.util.ArrayList;
import java.util.List;

public class SumAllSalesAmount {

    public int sumAllSalesAmount(List<Salesperson> salespersons) {
        int sum = 0;
        for (Salesperson salesperson: salespersons) {
            sum += salesperson.getAmount();
        }
        return sum;
    }


    public static void main(String[] args) {
        Salesperson salesperson1 = new Salesperson("Green", 1_500_000);
        Salesperson salesperson2 = new Salesperson("Yellow", 500_000);
        Salesperson salesperson3 = new Salesperson("Blue", 1_700_000);


        List<Integer> salespersonAmount = new ArrayList<>();
        salespersonAmount.add(salesperson1.getAmount());
        salespersonAmount.add(salesperson2.getAmount());
        salespersonAmount.add(salesperson3.getAmount());

        System.out.println(salespersonAmount.toString());


        List<Salesperson> salespersons = new ArrayList<>();
        salespersons.add(salesperson1);
        salespersons.add(salesperson2);
        salespersons.add(salesperson3);

        System.out.println(new SumAllSalesAmount().sumAllSalesAmount(salespersons));
    }
}
