package typeconversion.whichtype;

public class WhichType {
    public String whichType (String s) {
        // int i = Integer.parseInt(s);
        if (s.length() <= 8) {
            System.out.println("Konvertálható: byte-ba");
            return s;
        }
        if (s.length() <= 16 && s.length() >= 8) {
            System.out.println("Konvertálható: short-ba");
            return s;
        }
        if (s.length() <= 32 && s.length() >= 16) {
            System.out.println("Konvertálható: int-be");
            return s;
        }
        if (s.length() <= 64 && s.length() >= 32) {
            System.out.println("Csak: long-ban tárolható.");
            return s;
        }
        return s;
    }



    public static void main(String[] args) {
        new WhichType().whichType("100101");
        new WhichType().whichType("1001000100100101");
        new WhichType().whichType("1001000110010011001000100101");
        new WhichType().whichType("1001000110010011001001000100100100100000000001000100101");

    }
}
