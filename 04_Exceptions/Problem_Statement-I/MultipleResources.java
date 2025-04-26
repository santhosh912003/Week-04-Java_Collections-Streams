import java.util.*;
import java.io.*;


class MultipleResources{
  public static void main(String[] args){
    String input1 = "file1.txt";
    String input2 = "file2.txt";
    String output= "newfile.txt";
    
    
    try{
      BufferedReader one = new BufferedReader(new FileReader(input1));
      BufferedReader two = new BufferedReader(new FileReader(input2));
      BufferedWriter writer = new BufferedWriter(new FileWriter(output));
      
      String line;
      
      while((line = one.readLine()) != null){
        writer.write(line);
        writer.newLine();
      }
      
      while((line = two.readLine()) != null){
        writer.write(line);
        writer.newLine();
      }
      
      
    System.out.println("Files merged successfully into " + output);

  } 
  catch (IOException e) {
            System.out.println("An error occurred during file processing.");
            e.printStackTrace();
  }
  }
}