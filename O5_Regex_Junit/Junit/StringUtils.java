package org.rajesh;
import java.util.*;
import java.lang.*;


public class StringUtils {

    public Boolean isPalin(String val){
        String rev = new StringBuilder(val).reverse().toString();
        return rev.equals(val);
    }
    public String reverse(String s){
        String r = new StringBuilder(s).reverse().toString();
        return r;
    }

    public String Upper(String s){
        return s.toUpperCase();
    }


}
