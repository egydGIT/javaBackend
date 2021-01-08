package inheritancemethods.bear;

public class Bear3 {

    public static void hunt() {                     // public statikus met.
        System.out.println("Bear is hunting.");
        eat();
    }

    protected static void eat() {                   // protected statikus met.
        System.out.println("Bear is eating.");
    }
}