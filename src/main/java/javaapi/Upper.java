package javaapi;

import packages.greetings.Greeter; 
import java.lang.String;                        // de ezt nem kell külön importálni.

public class Upper {
    public static void main(String[] args) {
        System.out.println("Scanner, String osztály:  https://docs.oracle.com/javase/7/docs/api/ " );

        Greeter greeter = new Greeter();

        System.out.println( greeter.sayHello1() );

        System.out.println( greeter.sayHello1().toUpperCase());

    }
}
