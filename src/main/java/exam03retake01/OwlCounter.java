/*
Bagolyszámlálás
A OwlCounter oszály egy Map<String, Integer> attribútumban tárolja, hogy melyik megyében mennyi baglyot számoltak a madárszámlálók.
A readFromFile() metódussal (paraméterezése, visszatérési értéke kiderül a tesztesetből) töltsd be az értékeket egy fájlból!
A fájl formátuma a következő:

Bács-Kiskun=1000
Baranya=1050
Békés=980
Borsod-Abaúj-Zemplén=600
A getNumberOfOwls() metódus adja vissza a baglyok számát a paraméterként átadott megyében!

 */
package exam03retake01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class OwlCounter {

    private Map<String, Integer> owls = new HashMap<>();

    public void readFromFile(BufferedReader reader) throws IOException{
        String line;
        while ((line = reader.readLine()) != null) {
            // System.out.println(line);
            String[] parts = line.split("=");
            String country = parts[0];
            Integer count = Integer.parseInt(parts[1]);
            owls.put(country, count);
        }
        // System.out.println(owls);
    }

    public int getNumberOfOwls(String country) {
        return owls.get(country);
    }


    public static void main(String[] args) {
        OwlCounter owlCounter = new OwlCounter();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(OwlCounter.class.getResourceAsStream("owls.txt")))) {
            owlCounter.readFromFile(reader);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }

        System.out.println(owlCounter.getNumberOfOwls("Heves"));

    }
}
