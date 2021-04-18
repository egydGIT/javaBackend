package iostringwriter;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LongWordsTest {

    LongWords longWords = new LongWords();

    @Test
    public void testUseMethodMy() {
        List<String> testWords = List.of("MacroglossumStellatarum",
                "PalingeniaLongicauda");
        String s = longWords.useMethod(testWords);
        System.out.println(s);          // MacroglossumStellatarum: 
                                        // PalingeniaLongicauda: 

    }

    @Test
    public void writeWithStringWriterTest() {
        List<String> testWords = List.of("Pseudopseudohypoparathyroidism",
                "Supercalifragilisticexpialidocious",
                "Strengths");

        String s = longWords.writeWithStringWriter(testWords);
        String[] testS = s.split("\n");
        assertEquals(3, testS.length);
        assertEquals(true, testS[1].contains("34"));

    }

}