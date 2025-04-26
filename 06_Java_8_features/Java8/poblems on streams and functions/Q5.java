package org.rajesh.second;

import java.util.*;
import java.util.function.Consumer;

public class Q5 {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("hello");
        strings.add("world");
        strings.add("java");
        strings.add("programming");


        Consumer<String> printInUpperCase = str -> System.out.println(str.toUpperCase());


        strings.forEach(printInUpperCase);
    }
}
