package inheritancemethods.bear;

public class Grizzly2 extends Bear2 {

    public void speak() {
        System.out.println("Grizzly growls.");
    }

    public void sleep(int length) {
        System.out.println("Grizzly is sleeping for " + length + " hours.");
    }

    public void eat() {
        System.out.println("Grizzly is eating.");
    }

    public static void main(String[] args) {
        Grizzly2 grizzly2 = new Grizzly2();
        grizzly2.hunt();             //Bear is hunting. Grizzly is eating.
        grizzly2.eat();              //Grizzly is eating.
    }
}