import java.io.*;

public class Q6 {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try (
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(inputFilePath), "UTF-8")
            );
            BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(outputFilePath), "UTF-8")
            )
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                writer.write(line.toLowerCase());
                writer.newLine(); 
            }
            System.out.println("Conversion complete. Check '" + outputFilePath + "'");
        } catch (IOException e) {
            System.err.println("Error during file operation: " + e.getMessage());
        }
    }
}
