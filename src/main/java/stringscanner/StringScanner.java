package stringscanner;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StringScanner {

    public int readAndSumValuesMy(String intstring) {
        Scanner scanner = new Scanner(intstring);
        int sum = 0;
        while (scanner.hasNextInt()) {
            int i = scanner.nextInt();
            sum += i;
        }
        return sum;
    }

    public int readAndSumValuesMy(String intstring, String delimiter) {
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

    public int readAndSumValues(String intString, String delimiter) {
        try (Scanner scanner = new Scanner(intString)) {
            if (!isEmpty(delimiter)) {
                scanner.useDelimiter(delimiter);
            }
            return calculateWithScanner(scanner);
        }
    }

    private int calculateWithScanner(Scanner sc) {
        int sum = 0;
        try {
            while (sc.hasNext()) {
                sum += sc.nextInt();
            }
        } catch (InputMismatchException ex) {
            throw new IllegalArgumentException("Incorrect parameter string!", ex);
        }
        return sum;
    }

    public int readAndSumValues(String intString) {
        return readAndSumValues(intString, null);
    }

    public String filterLinesWithWordOccurrences(String text, String word) {
        if (isEmpty(text) || word == null || "".equals(word)) {                // hibakezelés
            throw new IllegalArgumentException("Incorrect parameter string!"); // ha text üres v. szó null v üres String
        }
        try (Scanner sc = new Scanner(text)) {             // try(Scannert zárja le, meghívja a close() met-t
                                                                    // fejlécében Scanner példányosítás, paraméter text
            StringBuilder sb = new StringBuilder();        // StringBuilder példányosítás, mert ez mutable
            while (sc.hasNextLine()) {                     // amíg: van következő sor, visszatérési érték boolean
                String line = sc.nextLine();               // line változónak adja értékül a beolvasott sort
                if (line.contains(word)) {                 // ha: ez a sor tartalmazza a keresett szót
                    sb.append(line);                       // StrinBuilder véáltozóhoz adja hozzá az aktuális sort
                    sb.append("\n");                       // és az Entert
                }
            }
            return sb.toString().trim();                // met. térjen vissza a S.Builder végső, ciklus utáni értékével
        }                                               // SB csak toString met-sal íratható ki konzolra
    }                                                   // trim() whitespace-t vágja le(?)

    private boolean isEmpty(String str) {
        return str == null || "".equals(str.trim());
    }


    public static void main(String[] args) {
        StringScanner stringScanner = new StringScanner();

        System.out.println(stringScanner.readAndSumValuesMy("12 13 14 15 16 17 18"));
        System.out.println(stringScanner.readAndSumValuesMy("12, 13, 14, 15, 16, 17, 18", ", "));

    }
}
