package org.rajesh;

// Problem5_PolicyHolderRiskAssessment.java
import java.util.*;
import java.util.stream.*;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;

    RiskAssessment(String holderId, String name, double riskScore) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
    }
}

public class Q5 {
    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
                new PolicyHolder("H1", "John", 65, "Life", 40000),
                new PolicyHolder("H2", "Doe", 70, "Life", 25000),
                new PolicyHolder("H3", "Jane", 45, "Health", 20000)
        );

        Map<String, List<RiskAssessment>> categorized = holders.stream()
                .filter(h -> h.policyType.equals("Life") && h.age > 60)
                .map(h -> new RiskAssessment(h.holderId, h.name, h.premiumAmount / h.age))
                .sorted((r1, r2) -> Double.compare(r2.riskScore, r1.riskScore))
                .collect(Collectors.groupingBy(
                        r -> r.riskScore > 0.5 ? "High Risk" : "Low Risk"
                ));

        categorized.forEach((category, assessments) -> {
            System.out.println(category + ":");
            assessments.forEach(a -> System.out.println(a.holderId + " " + a.name + " Score: " + a.riskScore));
        });
    }
}
