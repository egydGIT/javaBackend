package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {

    public static final String STAR_CHARACTER = "*";
    public static final String ENTER = "\n";

    public String createHistogram(BufferedReader reader) {
        StringBuilder sb = new StringBuilder();
        try (reader) {
            String line;
            while ((line = reader.readLine()) != null) {
                int numberFromFile = Integer.parseInt(line);
                sb.append(STAR_CHARACTER.repeat(numberFromFile)).append(ENTER);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new IllegalStateException("Can not find file.", e);
        }
    }
}
