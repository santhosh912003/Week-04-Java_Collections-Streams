import java.io.*;
import java.util.*;

public class Q10 {
    public static void main(String[] args) {
        String filePath = "textfile.txt";  // Replace with your text file path
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase();
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }

            wordCountMap.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(5)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
