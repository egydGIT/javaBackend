/*
Junior
A GitHubon a examples\week13d01\src\main\resources\iranyitoszamok-varosok-2021.csv fájl
tartalmazza a magyar városok listáját. Add vissza a leghosszabb nevű várost!
 */

package week13d01;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CityOperations {

    public String findCityWithMaxLength(BufferedReader reader) {            // HIBAKAZELŐ METÓDUS
        try {
            return findCity(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.", e);
            // e.printStackTrace();     // ha findCity() while c-ban hiba, nem jó a fájl felolvasása
                                        // lekezeli a hibát -> kiírja a konzolra
                                        // de main-ben fut tovább a vezérlés -> az info nem jut el a hívó félhez
                                        // csak naplózáshoz jó
        }

    }

    private String findCity(BufferedReader reader) throws IOException {     // MEGKERESI A LEGHOSSZABB VÁROSNEVET
                                                    // a kiv-t ott kezeljük, ahol ezt a met-t meghívjuk
        String maxCityName = "";

        int numberOfLine = 0;                                          // hibaüzenethez plusz info: hibás sor sorszáma
        // reader.readLine();                                          // átugorjuk a header-t, de kiszerveztük met-ba
        skipHeader(reader);
        numberOfLine++;

        String line;
        while ((line = reader.readLine()) != null) {
            numberOfLine++;
            // System.out.println(line);                                // össz beolvasott sor

//                if (line.startsWith("2025")) {                        // e.printStackTrace();
//                    throw new IllegalStateException("Error");
//                }

//                String[] parts = line.split(";");                     // kiszerveztük metódusba
//                String name = parts[1];
            String name = getNameFromLine(line, numberOfLine);
            // System.out.println(name);                                // össz beolvasott városnév

            if (name.length() > maxCityName.length()) {    // SZÉLSŐÉRTÉK KERESÉS tétele: megkeresi a leghosszabb várost
                maxCityName = name;
            }
        }
        if (maxCityName.equals("")) {                                   // ha nincs beolvasott városnév
            throw new IllegalArgumentException("No city found.");
        }
        System.out.println(maxCityName);                                // megtalált leghosszabb
        return maxCityName;
    }

    private String getNameFromLine(String line, int numberOfLine) throws IOException {      // DARABOLJA A SORT
        String[] parts = line.split(";");        // ; mentén darabol
        if (parts.length <= 1) {                       // ha tömbre hivatkozok, hogy ne dobjon ArrayOutOfBondsEx.-t
            throw new IllegalStateException("Illegal line! number: " + numberOfLine + " content: " + line);
        }
        String name = parts[1];                        // város neve a tömb 2. eleme
        return name;
    }

    private void skipHeader(BufferedReader bufferedReader) throws IOException {             // ÁTUGORJA AZ ELSŐ SORT (HEADER)
        bufferedReader.readLine();                     // beolvassuk az első sort, de nem kezdünk vele semmit
    }

    public static void main(String[] args) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of("src/main/resources/iranyitoszamok-varosok-2021.csv"))) {  // try-with-resources
            String city = new CityOperations().findCityWithMaxLength(bufferedReader);
            // System.out.println("***************");                       // e.printStackTrace();
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.", e);
        }
    }


}
