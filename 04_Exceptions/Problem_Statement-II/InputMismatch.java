import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try{
            System.out.println("enter num1 : ");
            int a = sc.nextInt();
            System.out.println("enter num2 : ");
            int b = sc.nextInt();
            System.out.println("quotient : " + (a/b));
        }catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch( InputMismatchException e){
            System.out.println(e.getMessage());
        }
    }
}
