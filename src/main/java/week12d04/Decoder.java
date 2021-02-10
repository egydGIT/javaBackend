/*
Junior
Töltsd le a példa bináris állomány a
https://github.com/Training360/strukturavalto-java-public/raw/master/examples/week12d04/src/main/resources/secret.dat címről!
Ez bájtokat tartalmaz, egy szöveg van titkosítva benne. Olvasd be bájtonként, és mindegyik bájthoz adjál hozzá tízet!
Ez valójában egy karakterkód, ezt alakítsd át char típusú értékké! Majd egymás után írd ki ezeket a konzolra!
Ne használj közöttük sortörést!

 */

package week12d04;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Decoder {

    // Letölteni a projekt főkönyvtárába. Fejlesztőeszközben is megjelenik.
    // Beolvasni binárisan kell majd. Szövegként megnyitva értelmezhetetlen: 

    public void decode(Path path) {         // par: fájl elérési útvonala
        try {
            byte[] bytes = Files.readAllBytes(path);   // fájl beolvasása: megnyitja, kiolvassa a bájtokat, beleteszi tömbbe
            for (byte b: bytes) {                      // ciklus végigmegy a beolvasott bájtokon
                char c = (char) (b + 10);              // minden bájthoz hozzáadunk 10-t -> kasztoljuk, típuskényszerítjük
                                                       // -> majd char-ré konvertáljuk
                System.out.print(c);                   // ne legyen sortörés: nem println()
            }
        } catch (IOException e) {                      // kiv kezelés
            throw new IllegalStateException("Can not find file.", e);
        }
    }

    public String decodeBigData(Path path) {            // nagy állomány esetén InputStream
                                                              // (egybe beolvasva memória foglaló, bájtonként beolvasva lassú)
                                                              // pufferelt megoldás: részenként kell beolvasni, tömb mérete megadható
        StringBuilder sb = new StringBuilder();
        try (InputStream is = Files.newInputStream(path)) {   // megnyitja a par-ül átadott fájlt
            byte[] buffer = new byte[10];                     // bájtokat tömbbe, pufferbe olvassa be
            int size;                                         // puffer = 10 bájt, fájl = 126 bájt  (szimuláljuk, hogy nagy a fájl)
            while ((size = is.read(buffer)) > 0) {            // read() beolvassa a fájlt a tömbbe és visszatér a méretével
                                                              // max a tömb méretét olvassa be, vagy ami maradt a fájlból
                // System.out.println(size);                        // 12 x 10 bájt     +    6 bájt
                for (int i = 0; i < size; i++) {              // ciklus csak a fájl méretéig megy (nagytömbnek elejét dolgozzuk fel)
                    char c = (char) (buffer[i] + 10);
                    sb.append(c);
                    //System.out.print(c);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Can not find file.", e);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //new Decoder().decode(Path.of("secret.dat"));        // Path interfész, .of() statikus metódus
        //new Decoder().decodeBigData(Path.of("secret.dat"));

        String result = new Decoder().decodeBigData(Path.of("secret.dat"));
        System.out.println(result);


    }

    /*
       _
      | |
      | | __ ___   ____ _
  _   | |/ _` \ \ / / _` |
 | |__| | (_| |\ V / (_| |
  \____/ \__,_| \_/ \__,_|

  supeeer! :-)
     */

}
