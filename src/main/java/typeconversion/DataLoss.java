package typeconversion;

public class DataLoss {
/*
    public void dataLoss(long number) {                                 // Explicit konverziók + adatvesztés
        System.out.println(number);
        // System.out.println(Integer.toBinaryString(number));

        float convertedNumber = (float) number;
        System.out.println(convertedNumber);
        // System.out.println(Integer.toBinaryString(convertedNumber));

        long dataLossNumber = (long) convertedNumber;
        System.out.println(dataLossNumber);
        // System.out.println(Integer.toBinaryString(dataLossNumber));
    }

    public static void main(String[] args) {
        DataLoss dataLoss = new DataLoss();

        dataLoss.dataLoss(1_489_279_436);               // 1489279436
                                                        // 1.48927949E9
                                                        // 1489279488
    }

 */


    // Solutions-ból CP:
    public static final int MAX_NUMBER_OF_LOSS = 3;       // oszt-hoz tartozó konstans deklarálása

    public void dataLoss() {
        long original = 0;                                          // long tipusú változó definiálása
        for (long counter = 0; counter < MAX_NUMBER_OF_LOSS; ) {    // for ciklus fejléc, végigiterál a konstans értékén
            long converted = (long) (float) original;               // vátozó kétszeri explicit konverziója
            if (converted != original) {                            // ha a változó konvertálás után nem egyezik meg
                                                                         // kezdeti értékével
                System.out.println("Original: " + original + " in binary: " + Long.toBinaryString(original));
                System.out.println("Converted: " + converted + " in binary: " + Long.toBinaryString(converted));
                                                    // írja ki: eredeti és konvertált számot + bináris reprezentációit
                counter++;                          // ???.............
            }
            original++;                             // ciklusváltozó növelése posztfix / egy operandusú operátorral
        }
    }

    public static void main(String[] args) {
        new DataLoss().dataLoss();                  // metódus hívás

        // Original: 16777217 in binary: 1000000000000000000000001
        // Converted: 16777216 in binary: 1000000000000000000000000
        // Original: 16777219 in binary: 1000000000000000000000011
        // Converted: 16777220 in binary: 1000000000000000000000100
        // Original: 16777221 in binary: 1000000000000000000000101
        // Converted: 16777220 in binary: 1000000000000000000000100

    }

}
