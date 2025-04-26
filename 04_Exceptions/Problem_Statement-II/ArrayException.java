import java.util.Scanner;

public class ArrayException {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the size of the array:");
            int size = sc.nextInt();
            int[] array = new int[size];
            System.out.println("Enter array elements:");
            for (int i = 0; i < size; i++) {
                array[i] = sc.nextInt();
            }
            System.out.println("enter index : ");
            int n = sc.nextInt();
            System.out.println(array[n]);
            
        }catch(NullPointerException e){
            System.out.println(" Array is null or empty "+ e.getMessage());
        }catch(IndexOutOfBoundsException e){
            System.out.println(" Array index is out of bounds "+ e.getMessage());
        }
    }
}
