package org.rajesh;

// Problem4_ClaimsAnalysis.java
import java.util.*;
import java.util.stream.*;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    String claimDate;
    String status;

    Claim(String claimId, String policyNumber, double claimAmount, String claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}

public class Q4 {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("C1", "P1", 6000, "2023-01-01", "Approved"),
                new Claim("C2", "P1", 7000, "2023-01-02", "Approved"),
                new Claim("C3", "P2", 4000, "2023-01-03", "Rejected"),
                new Claim("C4", "P3", 10000, "2023-01-04", "Approved")
        );

        Map<String, DoubleSummaryStatistics> policyStats = claims.stream()
                .filter(c -> c.status.equals("Approved") && c.claimAmount > 5000)
                .collect(Collectors.groupingBy(
                        c -> c.policyNumber,
                        Collectors.summarizingDouble(c -> c.claimAmount)
                ));

        policyStats.entrySet().stream()
                .sorted((e1, e2) -> Double.compare(e2.getValue().getSum(), e1.getValue().getSum()))
                .limit(3)
                .forEach(e -> System.out.println(e.getKey() + " Total: " + e.getValue().getSum() + ", Average: " + e.getValue().getAverage()));
    }
}
