package org.rajesh;
// Problem6_FraudDetection.java
import java.util.*;
import java.util.stream.*;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    String transactionDate;
    boolean isFraudulent;

    Transaction(String transactionId, String policyNumber, double amount, String transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }
}

class FraudStats {
    long fraudCount;
    double totalAmount;

    FraudStats(long fraudCount, double totalAmount) {
        this.fraudCount = fraudCount;
        this.totalAmount = totalAmount;
    }
}

public class Q6 {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("T1", "P1", 15000, "2023-01-01", true),
                new Transaction("T2", "P1", 20000, "2023-01-02", true),
                new Transaction("T3", "P2", 8000, "2023-01-03", true),
                new Transaction("T4", "P1", 18000, "2023-01-04", true),
                new Transaction("T5", "P3", 60000, "2023-01-05", true),
                new Transaction("T6", "P2", 12000, "2023-01-06", true)
        );

        Map<String, FraudStats> fraudData = transactions.stream()
                .filter(t -> t.isFraudulent && t.amount > 10000)
                .collect(Collectors.groupingBy(
                        t -> t.policyNumber,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> new FraudStats(list.size(), list.stream().mapToDouble(t -> t.amount).sum())
                        )
                ));

        fraudData.forEach((policy, stats) -> {
            if (stats.fraudCount > 5 || stats.totalAmount > 50000) {
                System.out.println("Alert for Policy: " + policy + " | Fraud Count: " + stats.fraudCount + " | Total Fraud Amount: " + stats.totalAmount);
            }
        });
    }
}
