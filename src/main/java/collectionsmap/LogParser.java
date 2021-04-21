package collectionsmap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class LogParser {

    private static final int NUMBER_OF_ELEMENTS = 3;
    private static final int POSITION_OF_IP_ADDRESS = 0;
    private static final int POSITION_OF_DATE = 1;
    private static final int POSITION_OF_LOGIN = 2;
    private static final String SEPARATOR = ":";
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // bejövő String formátuma a konverzióhoz

    public Map<String, List<Entry>> parseLog(String log) {
        try (Scanner scanner = new Scanner(log)) {                      // Scanner
            Map<String, List<Entry>> elements = new HashMap<>();        // Map if tipusú HashMap példányosítás
            // kulcs: String, érték: Entry lista
            while (scanner.hasNext()) {                                 // amíg a Scanner tud sort beolvasni
                String line = scanner.next();                           // beolvassa a köv. sort és Sting tip-ú változóhoz rendeli
                String[] lineElements = line.split(SEPARATOR);          // : elválasztó karakter mentén darabol, tömbbe ment
                if (lineElements.length != NUMBER_OF_ELEMENTS) {        // ha a feldolgozott sor nem 3 elemre bontható -> kivételt dob
                    throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
                }
                LocalDate date = convertDate(lineElements[POSITION_OF_DATE]);   // met: tömb megf. elemét String-ből LocalDate-re konvertálja
                fillMap(elements, new Entry(lineElements[POSITION_OF_IP_ADDRESS],
                        lineElements[POSITION_OF_LOGIN], date));
            }
            return elements;
        }
    }

    public void fillMap(Map<String, List<Entry>> elements, Entry entry) {    // par: üres map, entry obj. (met. híváskor hozza létre)
        if (!elements.containsKey(entry.getIpAddress())) {                   // ha map kulcsai közt nincs egyezés az entry obj. ip címével
            elements.put(entry.getIpAddress(), new ArrayList<>());           // akkor map-be tegye bele az új kulcsot, Érték: üres lista
        }
        elements.get(entry.getIpAddress()).add(entry);                       // map kulcs alapján elkéri a listát -> ehhez a listához add met-sal enty obj-t
    }

    public LocalDate convertDate(String date) {
        try {
            return LocalDate.parse(date, DATE_FORMAT);     // The text is parsed using the formatter, returning a date.
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Incorrect log: incorrect date");
        }
    }



    public Map<String, List<Entry>> parseLogMy(String log) {
        try (Scanner scanner = new Scanner(log)) {
            Map<String, List<Entry>> map = new HashMap<>();

            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] lineElements = line.split(SEPARATOR);
                if (lineElements.length != NUMBER_OF_ELEMENTS) {
                    throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
                }
                LocalDate date = LocalDate.parse(lineElements[POSITION_OF_DATE], DATE_FORMAT);
                Entry entry = new Entry(lineElements[POSITION_OF_IP_ADDRESS], lineElements[POSITION_OF_LOGIN], date);
                if (!map.containsKey(entry.getIpAddress())) {
                    map.put(entry.getIpAddress(), new ArrayList<>());
                }
                map.get(entry.getIpAddress()).add(entry);
            }
            return map;
        }
    }

}

