package week05d05;

public class User {

    /*
    Junior
    Készíts egy osztályt User néven, melynek van egy firstName (String), egy lastName (String) és egy email (String) mezője!
    Legyen ellenőrzés a User konstruktorában, mely hibát jelez, ha nincs @ és . (pont) az e-mail cimben!
    Készíts egy metódust is getFullName() névvel, mely visszaadja a firstName és a lastName változókat összefűzve.
    Legyen közöttük egy whitespace (" ").
     */

    private String firstName;
    private String lastName;
    private String email;

    public User(String firstName, String lastName, String email) {
        if (!email.contains("@") || !email.contains(".")) {
            throw new IllegalArgumentException("Invalid e-mail! " + email);
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public static void main(String[] args) {
        User user = new User("John", "Doe", "john.doe@gmail.com");
        System.out.println(user.getFullName());
        System.out.println(user.getEmail());

        User user1 = new User("John", "Doe", "john.doe*gmail.com");
    }
}
