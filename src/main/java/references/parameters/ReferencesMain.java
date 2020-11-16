package references.parameters;

public class ReferencesMain {
    public static void main(String[] args) {
        Person person1 = new Person("Nógrádi András", 21);
        Person person2 = new Person("Nógrádi Zsolt", 15);
        System.out.println(person1.getName());                          // Nógrádi András
        System.out.println(person2.getName());                          // Nógrádi Zsolt

        Person newPersen = person1;
        person2 = person1;                              // referencia cím másolása, ugyanarra az obj-ra mutatnak

        person2.setName("Nógrádi Rita");

        System.out.println(person1.getName());                          // Nógrádi Rita
        System.out.println(person2.getName());                          // Nógrádi Rita

        int number1 = 24;
        int number2 = number1;                          // primitív tipus: érték szerimti másolás

        number2++;

        System.out.println(number1);                                    // 24
        System.out.println(number2);                                    // 25

        person2 = new Person("Nógrádi Zsolt", 45);  // új ref címet kap a person2 változó
        System.out.println(person1.getName());                          // Nógrádi Rita
        System.out.println(person2.getName());                          // Nógrádi Zsolt

    }
}
