package org.rajesh;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordTest {

    Password validator = new Password();

    @Test
    @DisplayName("✅ Valid password with uppercase letter and digit")
    void testValidPassword() {
        assertTrue(validator.isValid("StrongPass1"));
    }

    @Test
    @DisplayName("❌ Password too short should fail validation")
    void testPasswordTooShort() {
        assertFalse(validator.isValid("S1hort"));
    }

    @Test
    @DisplayName("❌ Password without uppercase letter should fail")
    void testPasswordWithoutUppercase() {
        assertFalse(validator.isValid("strongpass1"));
    }

    @Test
    @DisplayName("❌ Password without digit should fail")
    void testPasswordWithoutDigit() {
        assertFalse(validator.isValid("StrongPass"));
    }

    @Test
    @DisplayName("❌ Null password should fail validation")
    void testNullPassword() {
        assertFalse(validator.isValid(null));
    }
}
