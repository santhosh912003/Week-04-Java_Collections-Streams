package org.rajesh.second;
import java.util.stream.*;
import java.util.*;


public class Q2 {
    public static void main(String[] args) {
        List<String> st = new ArrayList<>();
        st.add("Asia");
        st.add("Europe");
        st.add("Africa");
        st.add("Antartica");
        st.add("America");


        List<String> s =  st.stream().filter( x -> x.startsWith("A")).collect(Collectors.toList());
        System.out.println(s);
    }
}
