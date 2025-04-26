import java.io.*;
import java.util.*;



class UserService{
  private static final HashMap<String,String> users = new HashMap<>();
  
  public static void Register(String username, String pass){
    try{
      checkUserExistance(username);
      users.put(username,pass);
      System.out.println("User registered successfully: " + username);
      return;
      
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
  
  public static void checkUserExistance(String username){
    
      if(users.containsKey(username)){
        System.out.println("The user is already exists!!!!!");
        throw new UserAlreadyExistsException("This user has already registered!! try loggin in");
    }
    
    
  }
  
  public static void main(String[] args){
    users.put("rajesh", "!234");
    Register("Rajesh","23542");
    checkUserExistance("rajesh");
    
  }
  
}

class UserAlreadyExistsException extends RuntimeException{
  public UserAlreadyExistsException(String err){
    super(err);
  }
}

