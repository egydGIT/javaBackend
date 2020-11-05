package week02;

public class Phone {
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
        Phone pnone1 = new Phone("iPhone", 4823);
        Phone phone2 = new Phone("xiaomi", 5896);

        System.out.println( "Details Phone 1: " + pnone1.getType() + " " + pnone1.getMem() );
        System.out.println( "Details Phone 2: " + phone2.getType() + " " + phone2.getMem() );

    }

}
