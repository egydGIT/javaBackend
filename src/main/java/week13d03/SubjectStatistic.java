/*
Junior
Adott a következő szerkezetű fájl, beosztas.txt:

Albatrosz Aladin
biologia
9.a
2
Albatrosz Aladin
osztalyfonoki
9.a
1
Csincsilla Csilla
matematika
9.b
2

A fájl tantárgyfelosztást tartalmaz. A tanttárgyfelosztást 4-es blokkokban adjuk meg. Első sor a tanár neve,
majd a tantárgy, majd az osztály ahol tanítja és végül az, hogy heti hány órában.
Írj egy metódust,ami paraméterül várja egy tanár nevét, és kiírja, hogy hány órája van egy héten.
A fájl megtalálható a examples\week13d03\src\main\resources\beosztas.txt
 */

package week13d03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SubjectStatistic {

    // 1. VERZIÓ
    private List<Subject> list1 = new ArrayList<>();

    public void teachersReadFromFile(BufferedReader br) throws IOException {
        String name;
        String subject;
        String className;
        String line;
        int numberOfLessons;
        while ((name = br.readLine()) != null) {
            subject = br.readLine();
            className = br.readLine();
            line = br.readLine();
            numberOfLessons = Integer.parseInt(line);
            list1.add(new Subject(name, subject, className, numberOfLessons));
        }
    }

    public int weekWork(String name) {
        int sum = 0;
        for ( Subject s: list1 ) {
            if ( s.getTeacherName().equals(name) ) {
                sum += s.getNumberOfLessons();
            }
        }
        return sum;
    }


    // 2. VERZIÓ
    private List<Subject> list2 = new ArrayList<>();     // Ha Map lenne: melyik tanár tartotta a legtöbbet is megválaszolható lenne

    private void readFromFile(String fileName) {
        try (BufferedReader br = Files.newBufferedReader(Path.of(fileName))) {
            String[] block = new String[4];                    // egy adat blokk = 4 sor = 4 elemű String tömb = egy Subject objektum
            while ( (block[0] = br.readLine()) != null ) {     // első sor a tömb 0. eleme
                list2.add(processBlock(br, block));            // listához hozzáadjuk a beolvasott négyes blokkokat
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("Can not read file.", e);
        }
    }

    private Subject processBlock(BufferedReader br, String[] block) throws IOException {
        for (int i=1; i < 4; i++) {                 // 0. elem már benne van, további 3 elemet beolvassa
            block[i] = br.readLine();
        }
        return new Subject(block[0], block[1], block[2], Integer.parseInt(block[3]));  // tanár neve, tantárgy, osztály, óraszám
    }

    private int sumNumberOfLessons(String name) {           // megkap egy nevet
        int sum = 0;
        for ( Subject s: list2 ) {                          // végigmegy a listán
            if ( s.getTeacherName().equals(name) ) {        // ha a név egyezik
                sum += s.getNumberOfLessons();              // összeadja a hozzátartozó óraszámmot
            }
        }
        return sum;
    }


    // 3. VERZIÓ
    public int sumLessonsOfTeacherFromFile(String file, String teacherName) {
        int sum = 0;

        try ( BufferedReader br = Files.newBufferedReader(Path.of(file))) {
            String line;
            while ((line = br.readLine()) != null ) {        // név beolvasása
                if (line.equals(teacherName)) {
                    skipLines(br);                           // 2 sor átugrása
                    sum += Integer.parseInt(br.readLine());  // óraszám beolvasása, számmá konvertálás, összegzés
                }
            }


        } catch (IOException e) {
            throw new IllegalArgumentException("Can not read file.", e);
        }
        return sum;
    }

    private void skipLines(BufferedReader br) throws IOException {          // sorok átugrása
        br.readLine();                           // 2.sor: tantárgy
        br.readLine();                           // 3.sor: osztály
    }



    public static void main(String[] args) {
        // 1. VERZIÓ:
        SubjectStatistic st = new SubjectStatistic();
        Path file = Path.of("src/test/resources/beosztas.txt");
        try {
            BufferedReader br = Files.newBufferedReader(file);
            st.teachersReadFromFile(br);
        } catch (IOException e) {
            throw new IllegalArgumentException("Can not read file.", e);
        }

        System.out.println("Albatrosz Aladin: " + st.weekWork("Albatrosz Aladin") + " óra/hét");
        // System.out.println(st.list1.toString());


        // 2. VERZIÓ
        st.readFromFile("src/test/resources/beosztas.txt");
        // System.out.println(st.list2);
        System.out.println("Albatrosz Aladin: " + st.sumNumberOfLessons("Albatrosz Aladin") + " óra/hét");


        // 3. VERZIÓ
        System.out.println("Albatrosz Aladin: " +
                st.sumLessonsOfTeacherFromFile("src/test/resources/beosztas.txt", "Albatrosz Aladin") + " óra/hét");

    }

}
