import java.util.Scanner;

public class IntegerDivision {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("enter a : ");
            int a = sc.nextInt();
            System.out.println("enter b : ");
            int b = sc.nextInt();
            System.out.println("Quotient : " + a / b);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("operation executed ! ");
        }
    }
}
