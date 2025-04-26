import java.util.Scanner;

public class CalculateInterest {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("enter amount : ");
            double p = sc.nextDouble();
            System.out.println("enter rate : ");
            double r = sc.nextDouble();
            System.out.println("enter no of years : ");
            int t = sc.nextInt();
            if(p<0 || r < 0 || t<0){
                throw new IllegalArgumentException("principal amount,years and rate cannot be negative ");
            }else{
                double si = (p * r * t) / 100 ;
                System.out.println("interest : " + si);
            }
        }
        catch(ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
}
