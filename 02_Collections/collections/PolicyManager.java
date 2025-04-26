import java.time.LocalDate;
import java.util.*;


class PolicyManager {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();

    void addPolicy(Policy p) {
        hashSet.add(p);
        linkedHashSet.add(p);
        treeSet.add(p);
    }

    void showAllPolicies() {
        System.out.println("\nAll Policies:");
        for (Policy p : hashSet) System.out.println(p);
    }

    void showExpiringSoon() {
        System.out.println("\nExpiring Within 30 Days:");
        LocalDate now = LocalDate.now();
        for (Policy p : treeSet)
            if (!p.expiryDate.isAfter(now.plusDays(30)))
                System.out.println(p);
    }

    void showByCoverage(String type) {
        System.out.println("\nPolicies with Coverage: " + type);
        for (Policy p : hashSet)
            if (p.coverageType.equalsIgnoreCase(type))
                System.out.println(p);
    }

    void findDuplicates(List<Policy> list) {
        System.out.println("\nDuplicate Policies:");
        Set<String> seen = new HashSet<>();
        for (Policy p : list) {
            if (!seen.add(p.number)) System.out.println(p);
        }
    }

    public static void main(String[] args) {
        SimplePolicyManager mgr = new SimplePolicyManager();

        List<Policy> sample = Arrays.asList(
            new Policy("P001", "Alice", "2024-04-25", "Health", 1000),
            new Policy("P002", "Bob", "2024-05-10", "Auto", 2000),
            new Policy("P003", "Charlie", "2024-06-15", "Home", 3000),
            new Policy("P001", "Alice Dup", "2024-04-25", "Health", 1000)
        );

        for (Policy p : sample) mgr.addPolicy(p);

        mgr.showAllPolicies();
        mgr.showExpiringSoon();
        mgr.showByCoverage("Health");
        mgr.findDuplicates(sample);
    }
}


class Policy implements Comparable<Policy> {
    String number, holderName, coverageType;
    LocalDate expiryDate;
    double premium;

    Policy(String number, String holderName, String expiry, String coverageType, double premium) {
        this.number = number;
        this.holderName = holderName;
        this.expiryDate = LocalDate.parse(expiry);
        this.coverageType = coverageType;
        this.premium = premium;
    }

    public boolean equals(Object o) {
        return (o instanceof Policy) && this.number.equals(((Policy) o).number);
    }

    public int hashCode() {
        return number.hashCode();
    }

    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    public String toString() {
        return number + " | " + holderName + " | " + expiryDate + " | " + coverageType + " | " + premium;
    }
}
