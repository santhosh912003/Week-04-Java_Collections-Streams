package org.rajesh;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    UserRegistration userRegistration = new UserRegistration();

    @Test
    @DisplayName("Should successfully register user with valid details")
    void testValidUserRegistration() {
        // No exception should be thrown for valid data
        assertDoesNotThrow(() -> userRegistration.registerUser("validUser", "user@example.com", "validPass123"));
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException for empty username")
    void testEmptyUsername() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("", "user@example.com", "validPass123");
        });
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException for invalid email")
    void testInvalidEmail() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("validUser", "invalidEmail", "validPass123");
        });
    }

    @Test
    @DisplayName("Should throw IllegalArgumentException for password less than 8 characters")
    void testShortPassword() {
        assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("validUser", "user@example.com", "short");
        });
    }
}
