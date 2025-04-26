class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
class BankAccount{
    private static double balance;
    public BankAccount(){
        balance = 0;
    }
    public double getBalance(){
        return balance;
    }
    static void deposit(double amount){
        balance += amount;
        System.out.println("amount has been deposited successfully");
    } 
    static void withdraw(double amount) throws InsufficientBalanceException{
        if(amount<0){
            throw new IllegalArgumentException(" Invalid Amount !!!");
        }
        else if(amount > balance){
            throw new InsufficientBalanceException("Insufficient balance to withdraw the requested amount.");
        }else{
            balance-=amount;
            System.out.println("Withdrawal successful!");
            System.out.println("Balance : " + balance);
        }

    }
}
public class WithdrawAmount{
    public static void main(String[] args) {
        try{
            BankAccount b = new BankAccount();
            System.out.println("====depositing 40000====");
            BankAccount.deposit(40000);
            // System.out.println("====Withdrawing -2====");
            // BankAccount.withdraw(-2);
            System.out.println("===withdrawing 100000===");
            BankAccount.withdraw(100000);
        }catch(IllegalArgumentException e){
            System.out.println("invalid amount");
        }catch(InsufficientBalanceException e){
            System.out.println("Insuffiecient balance");
        }
    

    }
}