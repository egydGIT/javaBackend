package inheritancemethods.bear;

public class Bear {

    public void hunt() {                        // Változtatás nélkül öröklődik
        System.out.println("Bear is hunting.");
        eat();
    }

    public void speak() {                       // Változtatás nélkül öröklődhet, de leszármazott felülírja
        System.out.println("Bear roars.");
    }

    protected void sleep() {
        System.out.println("Bear is sleeping.");
    }

    private void eat() {                        // private - Grizzly-ből (leszármazottból) nem elérhető
        System.out.println("Bear is eating.");
    }

    protected void eatProtected() {             // protected - Grizzly-ből (leszármazottból) elérhető
        System.out.println("Bear is eating.");
    }

    public static void main(String[] args) {
        Bear bear = new Bear();
        bear.eat();              // Bear is eating.
    }
}