package org.rajesh.second;


import java.util.function.*;

@FunctionalInterface
interface Square{
    int sq(int a);

    default void printMessage(int number) {
        int square = sq(number); // Calculate the square using the abstract method
        System.out.println("The square of " + number + " is: " + square);
    }

}
public class Q8 {
    public static void main(String[] args) {
        int a = 5;
        Square s = (int val) -> val * val;

        s.printMessage(a);

    }
}
