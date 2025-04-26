package org.rajesh.second;
import java.util.*;
import java.util.stream.Collectors;


class Person{
    String name;
    int age;
    double salary;


    public Person(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
public class Q3 {

    public static void main(String[] args) {
        List<Person> p = new ArrayList<>();
        p.add(new Person("Rajesh",22,30000));
        p.add(new Person("Bhakya",21,32000));
        p.add(new Person("Akshaya",22,36000));

        List<Person> sorted = p.stream().sorted(Comparator.comparingInt(x -> x.age)).collect(Collectors.toList());

        for(Person pn : sorted){
            System.out.println(pn.name + " "+ pn.age + " " + pn.salary);

        }
     }


}
