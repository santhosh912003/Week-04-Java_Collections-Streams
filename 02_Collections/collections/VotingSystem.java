import java.util.*;

class VotingSystem {

    Map<String, Integer> voteCount = new HashMap<>();
    Map<String, Integer> sortedResults = new TreeMap<>();
    Map<String, Integer> voteOrder = new LinkedHashMap<>();

    public void castVote(String candidate) {
        voteCount.put(candidate, voteCount.getOrDefault(candidate, 0) + 1);
        voteOrder.putIfAbsent(candidate, 1);
        sortedResults.clear();
        sortedResults.putAll(voteCount);
    }

    public void showVotes() {
        System.out.println("\nCurrent Vote Count:");
        for (String c : voteCount.keySet()) {
            System.out.println(c + " -> " + voteCount.get(c));
        }
    }

    public void showSortedResults() {
        System.out.println("\nSorted Results:");
        for (String c : sortedResults.keySet()) {
            System.out.println(c + " -> " + sortedResults.get(c));
        }
    }

    public void showVoteOrder() {
        System.out.println("\nOrder of First Votes:");
        for (String c : voteOrder.keySet()) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        VotingSystem vs = new VotingSystem();

        vs.castVote("Alice");
        vs.castVote("Bob");
        vs.castVote("Charlie");
        vs.castVote("Bob");
        vs.castVote("Alice");

        vs.showVotes();
        vs.showSortedResults();
        vs.showVoteOrder();
    }
}
