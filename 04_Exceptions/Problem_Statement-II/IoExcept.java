import java.io.FileReader;
import java.io.IOException;

public class IoExcept{
    public static void main(String[] args) {
        try{
            FileReader file = new FileReader("data.txt");
            System.out.println("file found");
        }catch(IOException e){
            System.out.println( "An error occurred while trying to read the file: " + e.getMessage());
        }
        
    }

}