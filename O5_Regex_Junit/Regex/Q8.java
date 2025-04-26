import java.util.*;
import java.util.regex.*;

public class Q8 {
    public static String replaceMultipleSpaces(String text) {
        return Pattern.compile("\\s+").matcher(text).replaceAll(" ");
    }

    public static void main(String[] args) {
        System.out.println(replaceMultipleSpaces("This    is   a test"));
    }
}