package methodstructure.pendrives;

import java.util.ArrayList;
import java.util.List;

public class Pendrive {
    private String name;
    private int capacity;  // Gb
    private int price;      // Ft

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public void risePrice(int percent) {
        this.price = (int) (this.price * (1 + percent / 100.0));
    }

    public int comparePricePerCapacity(Pendrive pendrive) {
        if ( (this.getPrice() / this.getCapacity()) > (pendrive.getPrice() / pendrive.getCapacity()) ) {
            return 1;
        }
        if ( (this.getPrice() / this.getCapacity()) < (pendrive.getPrice() / pendrive.getCapacity()) ) {
            return -1;
        }
        /*
        if ( (this.getPrice() / this.getCapacity()) == (pendrive.getPrice() / pendrive.getCapacity()) ) {
            return 0;
        }
        */
        else return 0;
    }

    public boolean cheaperThan(Pendrive pendrive) {
        if (this.getPrice() < pendrive.getPrice()) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " : " + capacity + " : " + price;
    }

    public static void main(String[] args) {
        Pendrive pendrive1 = new Pendrive("Sundisk", 16, 4_000);
        Pendrive pendrive2 = new Pendrive("Toshiba", 16, 4_300);
        Pendrive pendrive3 = new Pendrive("Maxell", 32, 4_500);

        pendrive3.risePrice(15);
        System.out.println("Áremelés: " + pendrive3.getPrice());

        System.out.println("comparePricePerCapacity: " + pendrive1.comparePricePerCapacity(pendrive2));

        System.out.println("cheaperThan: " + pendrive1.cheaperThan(pendrive2));

        List<Pendrive> pendrives = new ArrayList<>();
        pendrives.add(pendrive1);
        pendrives.add(pendrive2);
        pendrives.add(pendrive3);
        System.out.println(pendrives);

        System.out.println("best: " + new Pendrives().best(pendrives));

        System.out.println("cheapest: " + new Pendrives().cheapest(pendrives));

        System.out.println("risePrice: " + new Pendrives().risePriceWhenCapacity(pendrives, 10, 16));

        System.out.println("findWhenCapacity: " + new Pendrives().findWhenCapacity(pendrives, 10, 16));



    }
}
