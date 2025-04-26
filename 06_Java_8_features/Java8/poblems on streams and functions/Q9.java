package org.rajesh.second;

import java.util.*;
import java.util.stream.*;

public class Q9 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 10, 15, 20, 25, 30);
        List<Integer> numbers1 = Arrays.asList();

        Optional<Integer> max = findMax(numbers);
        Optional<Integer> max1 = findMax(numbers1);
        max.ifPresentOrElse(
                val -> System.out.println("The maximum value is: "+ val),
                () ->System.out.println("This list is empty!")
        );

        max1.ifPresentOrElse(
                val -> System.out.println("The maximum value is: "+ val),
                () ->System.out.println("This list is empty!")
        );
    }

    public static Optional<Integer> findMax(List<Integer> nums){
        return nums.stream().max(Integer :: compareTo);
    }
}
