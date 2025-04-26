package org.rajesh;
import java.util.*;
import java.util.stream.*;


class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }
}



public class Q1 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 90000),
                new Employee(2, "Bob", "HR", 70000),
                new Employee(3, "Charlie", "Engineering", 85000),
                new Employee(4, "David", "Engineering", 75000)
        );

        Map<String, Double> result = employees.stream()
                .filter(e -> e.department.equals("Engineering") && e.salary > 80000)
                .sorted((e1, e2) -> Double.compare(e2.salary, e1.salary))
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.averagingDouble(e -> e.salary)
                ));

        result.forEach((dept, avgSalary) -> System.out.println(dept + ": " + avgSalary));
    }
}




