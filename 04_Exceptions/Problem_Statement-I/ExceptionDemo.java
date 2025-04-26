import java.io.*;



public class ExceptionDemo {

  
    public static void processData(String data) throws DataFormatException {
        if (data == null) {
            throw new NullDataException("Data is null! Cannot proceed.");
        }

        if (!data.matches("[a-zA-Z0-9]+")) {
            throw new DataFormatException("Data contains invalid characters!");
        }

        System.out.println("Processing data: " + data);
    }

    public static void main(String[] args) {
        String[] testInputs = { "Hello123", null, "Bad@Data!" };

        for (String input : testInputs) {
            try {
                processData(input);
            } catch (DataFormatException e) {
                System.out.println("Caught Checked Exception: " + e.getMessage());
            } catch (NullDataException e) {
                System.out.println("Caught Unchecked Exception: " + e.getMessage());
            }
        }

        System.out.println("Program continues running...");
    }
}

class DataFormatException extends Exception {
    public DataFormatException(String message) {
        super(message);
    }
}

class NullDataException extends RuntimeException {
    public NullDataException(String message) {
        super(message);
    }
}

