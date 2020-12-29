package introjunit;

public class Gentleman {

    private String name;

    public Gentleman(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String sayHello() {
        if ( name == null ) {
            return "Hello Anonymus";
        }
        return "Hello " + name;
    }
}
