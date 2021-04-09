package controlselection.accents;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhithoutAccentsTest {

    @Test
    public void testWith() {
        assertEquals('a', new WhithoutAccents().convertToCharWithoutAccents('á'));
        assertEquals('e', new WhithoutAccents().convertToCharWithoutAccents('é'));
        assertEquals('u', new WhithoutAccents().convertToCharWithoutAccents('ű'));
        assertEquals('U', new WhithoutAccents().convertToCharWithoutAccents('Ű'));
    }

    @Test
    public void testWithout() {
        assertEquals('a', new WhithoutAccents().convertToCharWithoutAccents('a'));
        assertEquals('g', new WhithoutAccents().convertToCharWithoutAccents('g'));
        assertEquals('z', new WhithoutAccents().convertToCharWithoutAccents('z'));
    }
}