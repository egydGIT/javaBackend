package week02d02;

public class Phone {

    /*
    2020-11-03 (week02d02)
        Írj egy Phone osztályt, type (String) és mem (int) attribútumokkal!
        Generálj konstruktort, gettert és settert!
        Írj bele egy main metódust, amivel példányosítasz egy osztályt, és kiírod az attribútumok értékeit!
     */

    private String type;
    private int mem;

    public Phone(String type, int mem) {
        this.type = type;
        this.mem = mem;
    }

    public String getType() {
        return type;
    }

    public int getMem() {
        return mem;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMem(int mem) {
        this.mem = mem;
    }

    public static void main(String[] args) {
        Phone phone = new Phone("iPhone", 1234567);
        System.out.println("type: " + phone.getType());
        System.out.println("mem: " + phone.getMem());
    }
}
