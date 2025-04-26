import java.io.*;
import java.util.*;

class Rethrowing{
  public static void method1(int num, int den){
    try{
      if(den>0){
        System.out.println(num/den);
      }
      else{
        throw new Exception("Error for division");
      }
      
    }
    catch(Exception e){
      throw new ArithmeticException("The denominator is Zero");
    }
    
    finally{
      System.out.println("Method one is executed");
    }
  }
  
  
  public static void method2(int num, int den){
    try{
      method1(num,den);
    }
    catch (Exception e){
      throw new  ArithmeticException("This is an Addition exception with more context");
    }
  }
  
  public static void main(String[] args){
    int num = 10;
    int den = 0;
    method1(num,den);
    System.out.println("Calling second method from main: ");
    method2(num,den);
  }
  
  
}