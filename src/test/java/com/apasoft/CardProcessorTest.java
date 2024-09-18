package com.apasoft;

import static org.junit.Assert.*;
import org.junit.Test;

public class CardProcessorTest {

    @Test
    public void testValidVisaCard() {
        String cardNumber = "4111111111111111";  // A valid VISA card number
        String expected = "4111 1111 1111 1111";
        
        String formatted = CardProcessor.formatCardNumber(cardNumber);
        assertEquals("Card number should be formatted in blocks of 4 digits", expected, formatted);
    }

    @Test
    public void testInvalidVisaCard() {
        String cardNumber = "5111111111111111";  // Invalid VISA card (doesn't start with 4)
        assertFalse("Card number should be invalid", cardNumber.matches("^4[0-9]{15}$"));
    }

    @Test
    public void testShortVisaCard() {
        String cardNumber = "4111111111111";  // Invalid VISA card (too short)
        assertFalse("Card number should be invalid due to length", cardNumber.matches("^4[0-9]{15}$"));
    }

    @Test
    public void testEmptyCardNumber() {
        String cardNumber = "";  // Empty card number
        assertFalse("Card number should be invalid because it's empty", cardNumber.matches("^4[0-9]{15}$"));
    }

    @Test
    public void testFormatCardNumber() {
        // Testing the formatCardNumber method directly with a valid VISA number
        String cardNumber = "4000123412341234";
        String expectedFormatted = "4000 1234 1234 1234";
        
        String actualFormatted = CardProcessor.formatCardNumber(cardNumber);
        assertEquals("Formatted card number should match the expected format", expectedFormatted, actualFormatted);
    }
}

