import java.util.*;

public class BankingSystem {

    Map<String, Double> accounts = new HashMap<>();
    Queue<String> withdrawalQueue = new LinkedList<>();

    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    public void requestWithdrawal(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            withdrawalQueue.offer(accountNumber);
        }
    }

    public void processWithdrawals(double amount) {
        while (!withdrawalQueue.isEmpty()) {
            String acc = withdrawalQueue.poll();
            double balance = accounts.get(acc);
            if (balance >= amount) {
                accounts.put(acc, balance - amount);
                System.out.println("Withdrawal of $" + amount + " successful for " + acc);
            } else {
                System.out.println("Insufficient funds for " + acc);
            }
        }
    }

    public void displayAccounts() {
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            System.out.println(entry.getKey() + " -> $" + entry.getValue());
        }
    }

    public void displaySortedByBalance() {
        TreeMap<Double, List<String>> sorted = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sorted.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        for (Map.Entry<Double, List<String>> entry : sorted.entrySet()) {
            for (String acc : entry.getValue()) {
                System.out.println(acc + " -> $" + entry.getKey());
            }
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount("ACC001", 5000);
        bank.addAccount("ACC002", 2000);
        bank.addAccount("ACC003", 3000);

        bank.requestWithdrawal("ACC001");
        bank.requestWithdrawal("ACC002");

        bank.processWithdrawals(1500);

        System.out.println("\nAll Accounts:");
        bank.displayAccounts();

        System.out.println("\nAccounts Sorted by Balance:");
        bank.displaySortedByBalance();
    }
}
