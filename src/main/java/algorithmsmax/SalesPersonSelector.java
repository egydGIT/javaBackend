package algorithmsmax;

import java.util.ArrayList;
import java.util.List;

public class SalesPersonSelector {

    public SalesPerson maxReceipts (List<SalesPerson> salesPeople) {
        SalesPerson salesPerson = null;
        for (SalesPerson person: salesPeople) {
            if (salesPerson == null || person.getAmount() > salesPerson.getAmount()) {
                salesPerson = person;
            }
        }
        return salesPerson;
    }

    public SalesPerson maxLargerThanTarget (List<SalesPerson> salesPeople) {
        SalesPerson salesPerson = null;
        for (SalesPerson person: salesPeople) {
            if (salesPerson == null ||
                    (person.getAmount() - person.getTarget()) > (salesPerson.getAmount() - salesPerson.getTarget())) {
                salesPerson = person;
            }
        }
        return salesPerson;
    }

    public SalesPerson maxLesserThanTarget (List<SalesPerson> salesPeople) {
        SalesPerson salesPerson = null;
        for (SalesPerson person: salesPeople) {
            if (salesPerson == null ||
                    (person.getTarget() - person.getAmount()) > (salesPerson.getTarget() - salesPerson.getAmount())) {
                salesPerson = person;
            }
        }
        return salesPerson;
    }


    public static void main(String[] args) {
        SalesPerson salesPerson1 = new SalesPerson("Jack", 500_000, 50_000);
        SalesPerson salesPerson2 = new SalesPerson("Tommy", 200_000, 300_000);
        SalesPerson salesPerson3 = new SalesPerson("Greg", 700_000, 300_000);

        List<SalesPerson> salesPeople = new ArrayList<>();
        salesPeople.add(salesPerson1);
        salesPeople.add(salesPerson2);
        salesPeople.add(salesPerson3);

        System.out.println(new SalesPersonSelector().maxReceipts(salesPeople).getName());
        System.out.println(new SalesPersonSelector().maxLargerThanTarget(salesPeople).getName());
        System.out.println(new SalesPersonSelector().maxLesserThanTarget(salesPeople).getName());


    }
}
