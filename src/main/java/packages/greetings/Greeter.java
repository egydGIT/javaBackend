package packages.greetings;

public class Greeter {
/*
    public String sayHello() {                  // ezt írtam én
        return "Hello World!";
    }
*/

    public void sayHello() {                   // mert a sout meghívja a toString() metódust... :)
        System.out.println("Hello World!");
    }

}
