package stringconcat.stringconcat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConcatNameTest {


    @Test
    public void invalidParametersShouldThrowExceptionNullFamilyName() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new ConcatName(null, "G", "John", Title.MR));
        assertEquals("Family name and given name must not be empty!", ex.getMessage());
    }

    @Test
    public void invalidParametersShouldThrowExceptionNullGivenName() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new ConcatName("Smith", "G", null, Title.MR));
        assertEquals("Family name and given name must not be empty!", ex.getMessage());
    }

    @Test
    public void invalidParametersShouldThrowExceptionEmptyFamilyName() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new ConcatName("", "G", "John", Title.MR));
        assertEquals("Family name and given name must not be empty!", ex.getMessage());
    }

    @Test
    public void invalidParametersShouldThrowExceptionEmptyGivenName() throws IllegalArgumentException {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new ConcatName("Smith", "G", "", Title.MR));
        assertEquals("Family name and given name must not be empty!", ex.getMessage());
    }

    @Test
    public void westernStyleNameConcatenation() {

        assertEquals("Mr. John G Smith", new ConcatName("Smith", "G", "John", Title.MR).concatNameWesternStyle());
        //assertEquals("John G Smith", new ConcatName("Smith", "G", "John").concatNameWesternStyle());
        assertEquals("Mr. John Smith", new ConcatName("Smith", "", "John", Title.MR).concatNameWesternStyle());
        assertEquals("Mr. John Smith", new ConcatName("Smith", null, "John", Title.MR).concatNameWesternStyle());
    }

    @Test
    public void hungarianStyleNameConcatenation() {

        assertEquals("Mr. Smith G John", new ConcatName("Smith", "G", "John", Title.MR).concatNameHungarianStyle());
        //assertEquals("Smith G John", new ConcatName("Smith", "G", "John").concatNameHungarianStyle());
        assertEquals("Mr. Smith John", new ConcatName("Smith", "", "John", Title.MR).concatNameHungarianStyle());
    }
}