import java.util.Scanner;

public class NestedTryCatch {
    public static void main(String[] args) {
        
        Scanner sc  = new Scanner(System.in);
        System.out.println("enter array length");
        int n = sc.nextInt();
        int arr[] = new int[n];

        System.out.println("enter array elements");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("enter divisor");
        int divisor = sc.nextInt();

        System.out.println("enter an index");
        int index = sc.nextInt();

        try {
            int element = arr[index]; // can throw ArrayIndexOutOfBoundsException

            try {
                int res = element / divisor; // can throw ArithmeticException
                System.out.println("Result: " + res);
            } catch (ArithmeticException e) {
                System.out.println("Divisor should not be zero");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        }

        sc.close();
    }
}
