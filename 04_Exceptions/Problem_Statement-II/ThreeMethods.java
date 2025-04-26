public class ThreeMethods {
    public static void method1(int a ,int b) throws ArithmeticException {
        if(b==0){
            throw new ArithmeticException("Division by zero is not allowed.");
        }else{
            System.out.println("Quotient : " + (a/b));
        }
    }

    public static void method2() {
        int a = 10;
        int b = 0;
        method1(a,b);
    }
    public static void main(String[] args) {
        try{
            method2();
        }catch(ArithmeticException e){
            System.out.println("handles arithmetic exception in main !");
        }
    }
}
