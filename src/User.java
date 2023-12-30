import java.util.Random;

public class User {

    //define variables for the user class
    private String username;
    private String password; 
    private int accountNumber; //accountNumber primarily used to link user and bank account
    private BankAccount bankAccount;

    //defualt constructor
    User(){
        this.username = "";
        this.password = "";
        this.accountNumber = 0;
        this.bankAccount = new BankAccount();
    }

    //constructor for brand new user
    User(String username, String password){

        this.username = username;
        this.password = password;
        this.accountNumber =  new Random().nextInt(1000000, 9999999);
        this.bankAccount = new BankAccount(username, accountNumber);
    }

    //overloaded constructor for registering user from database
    User(String username, String password, int accountNumber, BankAccount bankAccount){

        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.bankAccount = bankAccount;
    }

    //getters
    public String getUsername(){ 
        return this.username; 
    }

    public String getPassword(){ 
        return this.password; 
    }

    public int getAccountNumber(){ 
        return this.accountNumber; 
    }

    public BankAccount getBankAccount(){ 
        return this.bankAccount; 
    }

    //setters
    public void setUsername(String username){ 
        this.username = username; 
    }

    public void setPassword(String password){ 
        this.password = password; 
    }

    public void setAccountNumber(int accountNumber){ 
        this.accountNumber = accountNumber; 
    }

    public void setBankAccount(BankAccount bankAccount){ 
        this.bankAccount = bankAccount; 
    }
    
    public String toString(){
        return "Username: " + this.username + "\nPassword: " + this.password + "\nAccount Number: " + this.accountNumber + "\nBank Account: " + this.bankAccount.toString();
    }
}