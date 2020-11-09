package week02;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please give your mobile type: " );
        String type = scanner.nextLine();

        System.out.println("Please give your mobile mem number: " );
        int mem = scanner.nextInt();

        Phone phone = new Phone(type, mem);
        // Phone phone2 = new Phone("xiaomi", 5896);

        System.out.println( "Phone type: " +  phone.getType());
        System.out.println( "Phone mem number: " + phone.getMem());

    }


}
