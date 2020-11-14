package finalmodifier;

public class Gentleman<MESSAGE_PREFIX> {
    public static final String MESSAGE_PREFIX = "Hello ";

    public static final String MESSAGE_POSTFIX = " !";

    public String sayHello(String name) {
        return MESSAGE_PREFIX + name + MESSAGE_POSTFIX;
    }

    public static void main(String[] args) {
        System.out.println(new Gentleman().sayHello("Eszter"));
    }
}
