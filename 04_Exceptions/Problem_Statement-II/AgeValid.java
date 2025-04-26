class InvalidAgeException extends Exception{
    
    public InvalidAgeException(String message){
        super(message);
    }
}
public class AgeValid {
    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be above 18.");

        }
        return;
    }
    public static void main(String[] args) {
        try {
            validateAge(15);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
