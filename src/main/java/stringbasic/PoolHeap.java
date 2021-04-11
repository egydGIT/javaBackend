package stringbasic;

public class PoolHeap {

    String s = "Sting literal with many characters.";

    public String createStringForHeap(String s) {
        this.s = s;
        s = new String();                         // new String() mindenképpen új obj-ot hoz létre a heapen
        return s;
    }

    public String createStringForPool(String s) {
        this.s = s;
        s = s.intern();                           // intern() vizsgálja, a String a Pool-ban van-e, ha nincs, beleteszi
        return s;
    }

    public String createStringForHeap2(){         // Solution
        return new String("apple");
    }

    public String createStringForPool2(){         // Solution
        return "apple";
    }
}
