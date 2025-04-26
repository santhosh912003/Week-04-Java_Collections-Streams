package org.rajesh;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    Database obj;

    @BeforeEach
    public void setup(){
        obj = new Database();
    }


    @Test
    @DisplayName("Connection test")
    public void connectTest(){
        assertEquals(obj.connect(),"Database is connected","successfully");
    }

    @Test
    @DisplayName("DisConnection test")
    public void disconnectTest(){
        assertEquals(obj.disconnect(),"Database is disconnected","successfully");
    }

    @AfterAll
    public static void  complete(){
        System.out.println("All the Testcases are passed!!!");
    }
}
