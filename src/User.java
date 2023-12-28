import java.util.Random;

public class User {

    //define variables for the user class
    private String name; 
    private int accountNumber;
    private BankAccount bankAccount;

    //constructor for brand new user
    User(String name){

        this.name = name;
        this.accountNumber =  new Random().nextInt(1000000, 9999999);
        this.bankAccount = new BankAccount(name, accountNumber);
        
    }

    //overloaded constructor for registering user from database
    User(String name, int accountNumber, BankAccount bankAccount){

        this.name = name;
        this.accountNumber = accountNumber;
        this.bankAccount = bankAccount;
    }

    //getters
    public String getName(){ 
        return this.name; 
    }

    public int getAccountNumber(){ 
        return this.accountNumber; 
    }

    public BankAccount getBankAccount(){ 
        return this.bankAccount; 
    }

    //setters
    public void setName(String name){ 
        this.name = name; 
    }

    public void setAccountNumber(int accountNumber){ 
        this.accountNumber = accountNumber; 
    }

    public void setBankAccount(BankAccount bankAccount){ 
        this.bankAccount = bankAccount; 
    }
    
}