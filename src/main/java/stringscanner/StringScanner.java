package stringscanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringScanner {

    public int readAndSumValues(String intstring) {
        Scanner scanner = new Scanner(intstring);
        int sum = 0;
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            sum += i;
        }
        return sum;
    }

    public int readAndSumValues(String intstring, String delimiter) {
        Scanner scanner = new Scanner(intstring).useDelimiter(delimiter);
        List<Integer> numbers = new ArrayList<>();
        while (scanner.hasNextInt()) {
            numbers.add(scanner.nextInt());
        }
        // System.out.println(numbers);
        int sum = 0;
        for (Integer n : numbers) {
            sum += n;
        }
        return sum;
    }
/*
    public String filterLinesWithWordOccurrences(String text, String word) {

    }

 */

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }


    public static void main(String[] args) {
        StringScanner stringScanner = new StringScanner();

        System.out.println(stringScanner.readAndSumValues("12 13 14 15 16 17 18"));
        System.out.println(stringScanner.readAndSumValues("12, 13, 14, 15, 16, 17, 18", ", "));
    }
}
