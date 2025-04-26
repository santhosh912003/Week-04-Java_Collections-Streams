//package org.rajesh;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class isEvenTest {
//
//    isEven evenChecker;
//
//    @BeforeEach
//    void setup() {
//        evenChecker = new isEven();
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {2, 4, 6, 8, 10, 0, -2})
//    @DisplayName("Check even numbers using parameterized test")
//    void testEvenNumbers(int number) {
//        assertTrue(evenChecker.check(number), number + " should be even");
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {1, 3, 5, 7, 9, -1, -3})
//    @DisplayName("Check odd numbers using parameterized test")
//    void testOddNumbers(int number) {
//        assertFalse(evenChecker.check(number), number + " should be odd");
//    }
//}
