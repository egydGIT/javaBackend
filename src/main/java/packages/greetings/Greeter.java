package packages.greetings;

public class Greeter {

    public String sayHello1() {                  // ezt írtam én
        return "Hello World!";
    }


    public void sayHello2() {                   // mert a sout meghívja a toString() metódust... :)
        System.out.println("Hello World!");
    }


}
