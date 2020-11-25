package typeconversion;

public class DataLoss {
    public void dataLoss(long number) {
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

        dataLoss.dataLoss(1_489_279_436);
    }
}
