package org.rajesh;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class DateFormatterTest {

    DateFormatter formatter = new DateFormatter();

    @Test
    @DisplayName("Should correctly format valid date")
    void testValidDateFormatting() throws ParseException {
        String formattedDate = formatter.formatDate("2025-04-26");
        assertEquals("26-04-2025", formattedDate);
    }

    @Test
    @DisplayName("Should throw ParseException for invalid date format")
    void testInvalidDateFormat() {
        assertThrows(ParseException.class, () -> {
            formatter.formatDate("26/04/2025");
        });
    }

    @Test
    @DisplayName("Should throw ParseException for completely wrong date")
    void testCompletelyWrongDate() {
        assertThrows(ParseException.class, () -> {
            formatter.formatDate("invalid-date");
        });
    }
}
