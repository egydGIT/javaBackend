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
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Map<String, List<Entry>> parseLog(String log) {
        try (Scanner scanner = new Scanner(log)) {
            Map<String, List<Entry>> elements = new HashMap<>();

            while (scanner.hasNext()) {
                String line = scanner.next();
                String[] lineElements = line.split(SEPARATOR);
                if (lineElements.length != NUMBER_OF_ELEMENTS) {
                    throw new IllegalArgumentException("Incorrect log: incorrect number of fields");
                }
                LocalDate date = convertDate(lineElements[POSITION_OF_DATE]);
                fillMap(elements, new Entry(lineElements[POSITION_OF_IP_ADDRESS],
                        lineElements[POSITION_OF_LOGIN], date));
            }
            return elements;
        }
    }

    public void fillMap(Map<String, List<Entry>> elements, Entry entry) {
        if (! elements.containsKey(entry.getIpAddress())) {
            elements.put(entry.getIpAddress(), new ArrayList<>());
        }
        elements.get(entry.getIpAddress()).add(entry);
    }

    public LocalDate convertDate(String date) {
        try {
            return LocalDate.parse(date, DATE_FORMAT);     // The text is parsed using the formatter, returning a date.
        } catch (DateTimeParseException dtpe) {
            throw new IllegalArgumentException("Incorrect log: incorrect date");
        }
    }


}
