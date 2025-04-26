import java.io.*;

public class Q5 {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        BufferedReader reader = null;
        BufferedWriter writer = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile), "UTF-8"));
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }
            System.out.println("File has been converted successfully.");
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            try {
                if (reader != null) reader.close();
                if (writer != null) writer.close();
            } catch (IOException e) {
                System.err.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}
