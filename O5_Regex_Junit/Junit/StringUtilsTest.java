package org.rajesh;


import org.junit.jupiter.api.*;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.*;


public class StringUtilsTest {
    StringUtils obj;

    @BeforeEach
    public void setup(){
        obj = new StringUtils();
    }

    @Test
    @DisplayName("This is an Palindrome test case")
    public void PalinTest(){
        assertTrue(obj.isPalin("madam"),"madam - this is palindrome");
        assertFalse(obj.isPalin("rajesh"),"rajesh -  this is not a plaindrome");
    }

    @Test
    @DisplayName("this is an String reverse test")
    public void reverseTest(){
        assertEquals(obj.reverse("rajesh"),"hsejar","The string is reversed!");
    }


    @Test
    @DisplayName("This is an upper case test")
    public void UpperTest(){
        assertEquals(obj.Upper("rajesh"),"RAJESH","the string is upercased");


    }

    


    @AfterAll
    public static void Print1(){
        System.out.println("All the test cases are cleared!!");

    }

}
