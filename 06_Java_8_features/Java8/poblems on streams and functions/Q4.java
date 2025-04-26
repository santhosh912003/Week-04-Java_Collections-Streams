package org.rajesh.second;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class Q4 {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("JavaProgramming");
        strings.add("Python");
        strings.add("Java");
        strings.add("SpringBoot");
        strings.add("J2EE");
        strings.add("JavaFX");
        strings.add("GoLang");
        strings.add("C++");

        Predicate<String> lengthPredicate = str -> str.length() > 5;

        Predicate<String> javaPredicate = str -> str.toLowerCase().contains("java");

        List<String> filtered  = strings.stream().filter(lengthPredicate.and(javaPredicate)).collect(Collectors.toList());

        System.out.println(filtered);
    }
}
