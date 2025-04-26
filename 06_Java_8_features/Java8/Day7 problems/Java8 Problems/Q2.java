package org.rajesh;
// Problem2_ProductSalesAnalysis.java
import java.util.*;
import java.util.stream.*;

class Sale {
    String productId;
    int quantity;
    double price;

    Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

class ProductSales {
    String productId;
    double totalRevenue;

    ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }
}

public class Q2 {
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
                new Sale("P1", 15, 20.0),
                new Sale("P2", 8, 50.0),
                new Sale("P3", 20, 10.0),
                new Sale("P4", 5, 100.0)
        );

        List<ProductSales> result = sales.stream()
                .filter(s -> s.quantity > 10)
                .map(s -> new ProductSales(s.productId, s.quantity * s.price))
                .sorted((p1, p2) -> Double.compare(p2.totalRevenue, p1.totalRevenue))
                .limit(5)
                .collect(Collectors.toList());

        result.forEach(ps -> System.out.println(ps.productId + ": " + ps.totalRevenue));
    }
}
