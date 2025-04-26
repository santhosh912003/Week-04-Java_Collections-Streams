package org.rajesh;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ListManagerTest {

    ListManager manager;
    List<Integer> testList;

    @BeforeEach
    void setup() {
        manager = new ListManager();
        testList = new ArrayList<>();
    }

    @Test
    @DisplayName("Test element addition")
    void testAddElement() {
        manager.addElement(testList, 5);
        assertTrue(testList.contains(5), "List should contain the added element 5");
    }

    @Test
    @DisplayName("Test element removal")
    void testRemoveElement() {
        testList.add(10);
        manager.removeElement(testList, 10);
        assertFalse(testList.contains(10), "List should not contain the removed element 10");
    }

    @Test
    @DisplayName("Test list size updates correctly")
    void testGetSize() {
        manager.addElement(testList, 1);
        manager.addElement(testList, 2);
        manager.removeElement(testList, 1);
        assertEquals(1, manager.getSize(testList), "List size should be 1 after add and remove");
    }

    @AfterAll
    public static void Print1(){
        System.out.println("All the test cases are passes!!!");
    }
}

