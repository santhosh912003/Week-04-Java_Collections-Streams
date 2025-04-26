package org.rajesh;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;



public class FileProcessor {

    public void writeToFile(String file, String content) throws IOException{

            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
            writer.write(content);

    }

    public String readFromFile(String filename) throws IOException {
        return Files.readString(Path.of(filename));
    }
}
