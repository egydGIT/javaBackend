package array;

public class ArrayMain {

    public static void main(String[] args) {
        String [] daysOfWeek = {"Hétfő", "Kedd", "Szerda", "Csütörtök", "Péntek", "Szombat", "Vasárnap"};

        System.out.println("Második nap: " + daysOfWeek[1]);
        System.out.println("Napok száma: " + daysOfWeek.length);

        /*
        public class Main {                                 // Google hatvány
        public static void main(String[] args) {
            int alap = 2;
            int kitevo = 4;
            int eredmeny = 1;
            for (int i = 1; i <= kitevo; i++){
            eredmeny *= alap;
            }
        System.out.println(eredmeny);
        }
*/
//        int basic = 2;
//        int power = 5;
//        // int result = 1;
//        int [] result = new int[5];
//        result[0] = 1;
//        for ( int i = 0; i <= 4; i++) {
//            // result *= basic;
//            result[i] *= basic;
//            System.out.print(result[i] + " ");          // Konzol: 2 0 0 0 0          Miért?
//        }
//
//        System.out.println();
//        for(int r : result) {
//            System.out.print(r + " ");
//        }

/*
        System.out.println("");
        for ( int i = 0; i < 5; i++) {
            System.out.print(result[i] + " ");
        }
*/

        int[] powersOfTwo = new int[5];                   // Solution
        powersOfTwo[0] = 1;
        for (int i = 1; i < powersOfTwo.length; i++) {
            powersOfTwo[i] = powersOfTwo[i - 1] * 2;
        }

        for (int i = 0; i < powersOfTwo.length; i++) {
            System.out.print(powersOfTwo[i] + " ");
        }



//        System.out.println();
//        boolean [] b = new boolean[6];
//
//        for (int i = 1; i < b.length; i++) {
//            b[i] = !b[i-1];
//            System.out.print(b[i] + " ");
//        }                                               // true false true false true    Nem false kezdődik!


        System.out.println();

        boolean[] bools = new boolean[6];                 // Solution

        for (int i = 1; i < bools.length; i++) {
            bools[i] = !bools[i - 1];
        }

        for (int i = 0; i < bools.length; i++) {
            System.out.print(bools[i] + " ");
        }













    }


}
