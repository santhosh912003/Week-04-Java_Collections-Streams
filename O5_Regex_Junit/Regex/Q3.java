import java.util.*;
import java.util.regex.*;


public class Q3 {
    public static boolean isValidHexColor(String color) {
        return Pattern.matches("^#[0-9a-fA-F]{6}$", color);
    }

    public static void main(String[] args) {
        System.out.println(isValidHexColor("#FFA500")); // true
    }
}
