package org.rajesh.second;
import java.util.function.*;


public class Q7 {
    public static void main(String[] args) {

        BiFunction<String, String, String> addStrings = (s1,s2) -> s1+ " {space added} "+ s2;

        String s1 = "Rajesh";
        String s2 = "SDE @ Capgemini";

        String ans = addStrings.apply(s1,s2);

        System.out.println(ans);
    }
}
