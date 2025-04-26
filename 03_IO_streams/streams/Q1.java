import java.io.*;

class Q1 {
    public static void main(String[] args) {
        File source = new File("source.txt");
        File dest = new File("destination.txt");

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            int b;
            while ((b = fis.read()) != -1) {
                fos.write(b);
            }

            System.out.println("File copied successfully!");

        } catch (FileNotFoundException e) {
            System.out.println("Source file not found.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
