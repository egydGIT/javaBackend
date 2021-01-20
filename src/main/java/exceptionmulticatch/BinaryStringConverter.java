package exceptionmulticatch;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BinaryStringConverter {

    public boolean[] binaryStringToBooleanArray(String binaryString) {
        if (binaryString.isEmpty() || binaryString.isBlank()) {
            throw new NullPointerException("BinaryString is null.");
        }

        boolean[] booleanArray = new boolean[binaryString.length()];
        for (int i = 0; i < binaryString.length(); i++) {
            char c = binaryString.charAt(i);
            if ( c != '1' &&  c != '0') {
                throw new IllegalArgumentException("Invalid binaryString: " + binaryString);
            }
            boolean booleanValue = false;
            if (c == '1') {
                booleanValue = true;
            }
            if (c == '0') {
                booleanValue = false;
            }
            booleanArray[i] = booleanValue;
        }
        return booleanArray;
    }

    public String booleanArrayToBinaryString(boolean[] booleanArray) {
        if (booleanArray == null) {
            throw new NullPointerException("BooleanArray is null.");
        }
        if (booleanArray.length == 0) {
            throw new IllegalArgumentException("BooleanArray size is null.");
        }
        StringBuilder sb = new StringBuilder();
        for (Boolean b: booleanArray) {
            if (b == true) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        BinaryStringConverter bsc = new BinaryStringConverter();
        // System.out.println(bsc.binaryStringToBooleanArray("21380"));
        System.out.println(Arrays.toString(bsc.binaryStringToBooleanArray("01110")));  // [false, true, true, true, false]

        System.out.println(bsc.booleanArrayToBinaryString(new boolean[]{false, true, true, true, false})); // 01110
    }
}
