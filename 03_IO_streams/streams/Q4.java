import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;

public class Q4 {

    public static void main(String[] args) {
        String inputImagePath = "input_image.jpg";
        String outputImagePath = "output_image.jpg";

        try {
            byte[] imageBytes = imageToByteArray(inputImagePath);
            byteArrayToImage(imageBytes, outputImagePath);

            byte[] original = Files.readAllBytes(new File(inputImagePath).toPath());
            byte[] copied = Files.readAllBytes(new File(outputImagePath).toPath());

            if (Arrays.equals(original, copied)) {
                System.out.println("Success: The output image is identical to the original.");
            } else {
                System.out.println("Failure: The output image differs from the original.");
            }

        } catch (IOException e) {
            System.err.println("IOException occurred: " + e.getMessage());
        }
    }

    public static byte[] imageToByteArray(String imagePath) throws IOException {
        FileInputStream fis = new FileInputStream(imagePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = fis.read(buffer)) != -1) {
            baos.write(buffer, 0, bytesRead);
        }
        fis.close();
        return baos.toByteArray();
    }

    public static void byteArrayToImage(byte[] imageBytes, String outputPath) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
        FileOutputStream fos = new FileOutputStream(outputPath);
        byte[] buffer = new byte[4096];
        int bytesRead;
        while ((bytesRead = bais.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }
        bais.close();
        fos.close();
    }
}
