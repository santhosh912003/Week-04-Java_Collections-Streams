package org.rajesh.second.insurance;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Q1 {

    static class Policy {
        private String policyNumber;
        private String holderName;
        private double premiumAmount;

        public Policy(String policyNumber, String holderName, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.holderName = holderName;
            this.premiumAmount = premiumAmount;
        }

        public String getPolicyNumber() {
            return policyNumber;
        }

        public String getHolderName() {
            return holderName;
        }

        public double getPremiumAmount() {
            return premiumAmount;
        }

        @Override
        public String toString() {
            return "PolicyNumber: " + policyNumber +
                    ", HolderName: " + holderName +
                    ", PremiumAmount: $" + premiumAmount;
        }
    }

    public static void main(String[] args) {
        List<Policy> policies = Arrays.asList(
                new Policy("P001", "John Smith", 1500),
                new Policy("P002", "Alice Johnson", 950),
                new Policy("P003", "Bob Brown", 2200),
                new Policy("P004", "Charlie Davis", 1750),
                new Policy("P005", "Eve Adams", 2500),
                new Policy("P006", "Smithson Turner", 1250)
        );

        System.out.println("\n1. Filter policies > $1200:");
        List<Policy> filteredPolicies = policies.stream()
                .filter(p -> p.getPremiumAmount() > 1200)
                .collect(Collectors.toList());
        filteredPolicies.forEach(System.out::println);

        System.out.println("\n2. Sort policies by holder name:");
        List<Policy> sortedByName = policies.stream()
                .sorted(Comparator.comparing(Policy::getHolderName))
                .collect(Collectors.toList());
        sortedByName.forEach(System.out::println);

        System.out.println("\n3. Compute total premium:");
        double totalPremium = policies.stream()
                .mapToDouble(Policy::getPremiumAmount)
                .sum();
        System.out.println("Total Premium: $" + totalPremium);

        System.out.println("\n4. Print policy details:");
        policies.forEach(p -> System.out.println(p));

        System.out.println("\n5. Filter policies between $1000 and $2000:");
        List<Policy> rangePolicies = policies.stream()
                .filter(p -> p.getPremiumAmount() >= 1000 && p.getPremiumAmount() <= 2000)
                .collect(Collectors.toList());
        rangePolicies.forEach(System.out::println);

        System.out.println("\n6. Find policy with highest premium:");
        policies.stream()
                .max(Comparator.comparingDouble(Policy::getPremiumAmount))
                .ifPresent(System.out::println);

        System.out.println("\n7. Group policies by holder name initial:");
        Map<Character, List<Policy>> groupedByInitial = policies.stream()
                .collect(Collectors.groupingBy(p -> p.getHolderName().charAt(0)));
        groupedByInitial.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

        System.out.println("\n8. Compute average premium:");
        policies.stream()
                .mapToDouble(Policy::getPremiumAmount)
                .average()
                .ifPresent(avg -> System.out.println("Average Premium: $" + avg));

        System.out.println("\n9. Sort policies by premium and print:");
        policies.stream()
                .sorted(Comparator.comparingDouble(Policy::getPremiumAmount))
                .forEach(System.out::println);

        System.out.println("\n10. Check if any policy exceeds $2000:");
        boolean exceeds2000 = policies.stream()
                .anyMatch(p -> p.getPremiumAmount() > 2000);
        System.out.println("Any policy > $2000? " + exceeds2000);

        System.out.println("\n11. Count policies for each premium range:");
        Map<String, Long> rangeCount = policies.stream()
                .collect(Collectors.groupingBy(p -> {
                    if (p.getPremiumAmount() <= 1000) return "$0-$1000";
                    else if (p.getPremiumAmount() <= 2000) return "$1001-$2000";
                    else return ">$2000";
                }, Collectors.counting()));
        rangeCount.forEach((k, v) -> System.out.println(k + ": " + v));

        System.out.println("\n12. Extract unique holder names:");
        List<String> uniqueHolderNames = policies.stream()
                .map(Policy::getHolderName)
                .distinct()
                .collect(Collectors.toList());
        uniqueHolderNames.forEach(System.out::println);

        System.out.println("\n13. Find policies by holder name containing 'Smith':");
        List<Policy> smithPolicies = policies.stream()
                .filter(p -> p.getHolderName().toLowerCase().contains("smith"))
                .collect(Collectors.toList());
        smithPolicies.forEach(System.out::println);

        System.out.println("\n14. Create map of policy numbers to premium amounts:");
        Map<String, Double> policyMap = policies.stream()
                .collect(Collectors.toMap(Policy::getPolicyNumber, Policy::getPremiumAmount));
        policyMap.forEach((k, v) -> System.out.println(k + " => $" + v));

        System.out.println("\n15. Most frequent words in text corpus:");
        String text = "Hello world! Hello Java. Java streams and Java lambda expressions. Streams are powerful.";
        findMostFrequentWords(text, 3);

        System.out.println("\n16. Find second most repeated word:");
        findSecondMostFrequentWord(text);
    }

    // 15. Find top N most frequent words
    public static void findMostFrequentWords(String text, int n) {
        String[] words = text.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+");

        Map<String, Long> frequencyMap = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .limit(n)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    // 16. Find second most repeated word
    public static void findSecondMostFrequentWord(String text) {
        String[] words = text.toLowerCase().replaceAll("[^a-z\\s]", "").split("\\s+");

        Map<String, Long> frequencyMap = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Map.Entry<String, Long>> sorted = frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());

        if (sorted.size() >= 2) {
            System.out.println("Second most frequent word: " + sorted.get(1).getKey() + " (" + sorted.get(1).getValue() + " times)");
        } else {
            System.out.println("Not enough words to find second most frequent.");
        }
    }
}

