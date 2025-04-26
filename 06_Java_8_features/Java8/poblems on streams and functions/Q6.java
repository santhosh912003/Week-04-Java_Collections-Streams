package org.rajesh.second;
import java.util.function.*;

public class Q6 {



    public static void main(String[] args) {

        double radius = 5.0;

        Function<Double, Double> area = r -> 3.14 * r * r;

        double a = area.apply(radius);

        System.out.println("The area of the circle of the given radius is: "+ a);
    }
}
