import java.io.*;

public class SimplePipeExample {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            Thread writer = new Thread(() -> {
                try {
                    String message = "Hello from the writer thread!";
                    pos.write(message.getBytes());
                    pos.close();
                } catch (IOException e) {
                    System.out.println("Writer error: " + e.getMessage());
                }
            });

            Thread reader = new Thread(() -> {
                try {
                    int data;
                    System.out.print("Reader received: ");
                    while ((data = pis.read()) != -1) {
                        System.out.print((char) data);
                    }
                    System.out.println();
                } catch (IOException e) {
                    System.out.println("Reader error: " + e.getMessage());
                }
            });

            writer.start();
            reader.start();
            writer.join();
            reader.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
