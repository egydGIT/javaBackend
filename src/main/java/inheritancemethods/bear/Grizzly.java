package inheritancemethods.bear;

public class Grizzly extends Bear {

    public void speak() {               // Override - az ősben lévő met-sal azonos a szignatúrájuk, de más az implementációjuk
        System.out.println("Grizzly growls.");
    }

    public void sleep(int length) {     // Overload: met. túlterhelés - mert a szignatúra eltérő a két met-ban
        System.out.println("Grizzly is sleeping for " + length + " hours.");
    }

    public boolean eat() {              // Hide: elrejti Egy új metódus lett deklarálva.
        System.out.println("Grizzly is eating.");
        return true;
    }
/*
    public boolean eatProtected() {     // protected láthatóság az ősben: met.-t nem rejti el a leszármazott elől,
        System.out.println("Bear is eating.");   // nem lehet azonos néven, azonos par.szign.val, eltérő vissz. értékkel 2 met.t deklarálni
    }

 */

    public static void main(String[] args) {
        Grizzly grizzly = new Grizzly();
        grizzly.hunt();             // Bear is hunting. Bear is eating.
        grizzly.sleep();            // Bear is sleeping.
        grizzly.sleep(10);    // Grizzly is sleeping for 10 hours.
        grizzly.speak();            // Grizzly growls.
        grizzly.eat();              // Grizzly is eating.

        Bear bear = new Bear();
        // bear.eat();              // innen nem hívható, mert private
        bear.eatProtected();        // Bear is eating.
    }
}