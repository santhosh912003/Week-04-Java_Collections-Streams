package org.rajesh;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    TemperatureConverter converter = new TemperatureConverter();

    @Test
    @DisplayName("✅ Should correctly convert 0°C to 32°F")
    void testCelsiusToFahrenheitZero() {
        double result = converter.celsiusToFahrenheit(0);
        assertEquals(32.0, result, 0.0001);
    }

    @Test
    @DisplayName("✅ Should correctly convert 100°C to 212°F")
    void testCelsiusToFahrenheitHundred() {
        double result = converter.celsiusToFahrenheit(100);
        assertEquals(212.0, result, 0.0001);
    }

    @Test
    @DisplayName("✅ Should correctly convert 32°F to 0°C")
    void testFahrenheitToCelsiusThirtyTwo() {
        double result = converter.fahrenheitToCelsius(32);
        assertEquals(0.0, result, 0.0001);
    }

    @Test
    @DisplayName("✅ Should correctly convert 212°F to 100°C")
    void testFahrenheitToCelsiusTwoTwelve() {
        double result = converter.fahrenheitToCelsius(212);
        assertEquals(100.0, result, 0.0001);
    }
}
