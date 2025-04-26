public class ConnectionManager {
    public static void main(String[] args) {
        DummyConnection conn = new DummyConnection();

        try {
            conn.open();
            conn.use();  // Might throw an exception
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e.getMessage());
        } finally {
            conn.close(); // Ensures cleanup happens
        }

        System.out.println("Program continues...");
    }
}

class DummyConnection {
    private boolean isOpen = false;

    public void open() {
        isOpen = true;
        System.out.println("Connection opened.");
    }

    public void use() throws Exception {
        if (!isOpen) {
            throw new IllegalStateException("Connection is not open!");
        }
        System.out.println("Using connection...");
        throw new Exception("Something went wrong while using the connection.");
    }

    public void close() {
        isOpen = false;
        System.out.println("Connection closed.");
    }
}


