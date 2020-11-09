package packages.main;

import packages.greetings.Greeter;

public class MainProgram {                                 // ez működik. automatikusan importálta a classt
    public static void main(String[] args) {
        // Greeter greeter = new Greeter();
        // System.out.println(greeter.sayHello1());

        new Greeter().sayHello2();                         // solution-ból a megoldás
    }
}
