package org.rajesh;

import org.junit.jupiter.api.*;
import java.io.File;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class FileProcessorTest {

    private FileProcessor processor;
    private final String testFile = "testfile.txt";

    @BeforeEach
    void setup() {
        processor = new FileProcessor();
    }

    @AfterEach
    void cleanup() {
        File file = new File(testFile);
        if (file.exists()) file.delete();  // Clean up after each test
    }

    @Test
    void testWriteAndRead() throws IOException {
        String content = "Hello, Rajesh!";
        processor.writeToFile(testFile, content);

        String readContent = processor.readFromFile(testFile);
        assertEquals(content, readContent);
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        processor.writeToFile(testFile, "Sample text");
        File file = new File(testFile);
        assertTrue(file.exists());
    }

    @Test
    void testReadFromMissingFileThrowsIOException() {
        String nonExistentFile = "missing_file.txt";
        assertThrows(IOException.class, () -> processor.readFromFile(nonExistentFile));
    }
}
