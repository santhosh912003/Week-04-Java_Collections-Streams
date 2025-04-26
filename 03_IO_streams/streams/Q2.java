import java.io.*;

class Q2{

    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {
        String sourceFile = "source_large_file.txt";
        String destUnbuffered = "dest_unbuffered.txt";
        String destBuffered = "dest_buffered.txt";

        long timeUnbuffered = copyFileUnbuffered(sourceFile, destUnbuffered);
        long timeBuffered = copyFileBuffered(sourceFile, destBuffered);

        System.out.println("Time taken using Unbuffered Streams: " + timeUnbuffered + " ns (" + (timeUnbuffered / 1_000_000) + " ms)");
        System.out.println("Time taken using Buffered Streams  : " + timeBuffered + " ns (" + (timeBuffered / 1_000_000) + " ms)");
    }

    public static long copyFileUnbuffered(String source, String dest) {
        long startTime = System.nanoTime();

        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(dest)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.err.println("Error in unbuffered copy: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static long copyFileBuffered(String source, String dest) {
        long startTime = System.nanoTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;

            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }

        } catch (IOException e) {
            System.err.println("Error in buffered copy: " + e.getMessage());
        }

        long endTime = System.nanoTime();
        return endTime - startTime;
    }
}
