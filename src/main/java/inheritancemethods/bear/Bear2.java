package inheritancemethods.bear;

public class Bear2 {

    public void hunt() {
        System.out.println("Bear is hunting.");
        eat();
    }

    public void speak() {
        System.out.println("Bear roars.");
    }

    protected void sleep() {
        System.out.println("Bear is sleeping.");
    }

    protected void eat() {
        System.out.println("Bear is eating.");
    }
}