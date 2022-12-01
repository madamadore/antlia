package it.antlia.store;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.Test;

public class RomanTest {
    
    Roman roman = new EsercizioLuca();

    @Test
    public void testToRomanWith5() {
        String result = roman.toRoman(5);
        assertEquals("V", result);
    }

    @Test
    public void testToRomanWith512() {
        String result = roman.toRoman(512);
        assertEquals("DXII", result);
    }

    @Test
    public void testToRomanWith90() {
        String result = roman.toRoman(90);
        assertEquals("XC", result);
    }

    @Test
    public void testToRomanWith0() {
        String result = roman.toRoman(0);
        assertEquals("", result);
    }

    @Test
    public void testToRomanWith1001() {
        String result = roman.toRoman(1001);
        assertNull(result);
    }

    @Test
    public void testToRomanWith1000() {
        String result = roman.toRoman(1000);
        assertEquals("M", result);
    }
}
