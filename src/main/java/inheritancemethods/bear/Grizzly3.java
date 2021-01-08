package inheritancemethods.bear;

public class Grizzly3 extends Bear3 {

    public static void eat() {        // leszármazitt statikus eat() met.a, elrejti a szülőben lévőt, nem felülírja!
        System.out.println("Grizzly is eating.");
    }

    public static void main(String[] args) {
        Grizzly3.hunt();             // Bear is hunting. Bear is eating. -> szülőben definiált met., szülő eat() met.t hívja
        Grizzly3.eat();              // Grizzly is eating.

        Bear3 bear3 = new Grizzly3();                // statikus met.ok statikusan kötődik az őket hívó vált. tipusához
        Grizzly3 grizzly3 = new Grizzly3();          // ugyanazon oszt.beli met. lesz meghívva, mint ahonnan hívják
        bear3.eat();         // Bear is eating.      // nem az obj. számít, hanem a vált. típusa
        grizzly3.eat();      // Grizzly is eating.

    }

}