import java.util.*;
import java.io.*;

public class FileProcessor{
  
  
  
  public static void processFiles(List<String> paths){
    
    
    for(String path: paths){
      try(BufferedReader br = new BufferedReader(new FileReader(path))){
        String line;
        System.out.println("Reading files: "+ path);
        while((line = br.readLine())!= null){
          System.out.println(line);
        }
        br.close();
      }
      catch(IOException e){
        System.out.println("Error reading file: "+ path);
        e.printStackTrace();
      }
      
      
      
    
    }
  }
  
  
  public static void main(String[] args){
    List<String> files = List.of("file1.txt","file2.txt");
    processFiles(files);
  }
}