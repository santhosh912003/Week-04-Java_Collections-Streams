import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {
    public static void main(String[] args){
        try(BufferedReader br = new BufferedReader(new FileReader("textfile.txt"))){
            String b;
            while( (b = br.readLine() ) != null ){
                System.out.println(b);
            }

        }catch(FileNotFoundException e){
            System.out.println("File not found ");
        }catch(IOException e){
            System.out.println("error reading the file");
        }
        System.out.println("file closed");
    }
}
