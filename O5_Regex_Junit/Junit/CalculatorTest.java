package org.rajesh;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculatorTest {
    Calculator calc;

    @BeforeEach
    void setup(){
        calc = new Calculator();
    }

    @Test
    @DisplayName("Addition test case")
    void addTest(){
        int res = calc.add(3,4);
        assertEquals(7,res,"3+4 SHOULD EQUAL 7");
    }

    @Test
    @DisplayName("Substract test case")
    void subTest(){
        int res = calc.subtract(3,4);
        assertEquals(-1,res,"3-4 SHOULD EQUAL -1");
    }

    @Test
    @DisplayName("Multiply test case")
    void MultiplyTest(){
        int res = calc.multiply(30,4);
        assertEquals(120,res,"30*4 SHOULD EQUAL 120");
    }

    @Test
    @DisplayName("Divison  test case")
    void DivideTest(){

        assertThrows(ArithmeticException.class , () -> {
            calc.divide(10,0);
        },"Division by Zero Error occured!");


    }
}
