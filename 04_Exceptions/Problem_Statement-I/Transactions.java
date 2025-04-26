import java.util.*;

import java.io.*;


lass Transactions{
  private static int balance = 200;
  public static void main(String[] args){
    int val = 1000;
    try{
    trans(100);
    trans(1000);
    }
    catch (CustomException e){
      System.out.println(e.getMessage());
    }
    
    
  }
  
  public static void trans(int val){
    if(val>balance){
      throw new CustomException("This amount the user entered is greater than the balance amount");
    }
    else{
      System.out.println("The amount is withdrawed: "+ val);
    }
  }
}

class CustomException extends RuntimeException{
  public CustomException(String err){
    super(err);
  }
  
}


 
c