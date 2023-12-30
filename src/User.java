import java.util.Random;

public class User {

    //define variables for the user class
    private String username; 
    private int accountNumber;
    private BankAccount bankAccount;

    //constructor for brand new user
    User(String username){

        this.username = username;
        this.accountNumber =  new Random().nextInt(1000000, 9999999);
        this.bankAccount = new BankAccount(username, accountNumber);
        
    }

    //overloaded constructor for registering user from database
    User(String username, int accountNumber, BankAccount bankAccount){

        this.username = username;
        this.accountNumber = accountNumber;
        this.bankAccount = bankAccount;
    }

    //getters
    public String getusername(){ 
        return this.username; 
    }

    public int getAccountNumber(){ 
        return this.accountNumber; 
    }

    public BankAccount getBankAccount(){ 
        return this.bankAccount; 
    }

    //setters
    public void setusername(String username){ 
        this.username = username; 
    }

    public void setAccountNumber(int accountNumber){ 
        this.accountNumber = accountNumber; 
    }

    public void setBankAccount(BankAccount bankAccount){ 
        this.bankAccount = bankAccount; 
    }
    
}