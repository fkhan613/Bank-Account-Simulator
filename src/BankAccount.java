import java.util.Random;

public class BankAccount {

    //define bank account variables
    private int accountNumber;
    private String accountHolderName;
    private float balance;

    //constructor
    BankAccount(String accountHolderName){

        this.accountHolderName = accountHolderName;
        this.accountNumber =  new Random().nextInt(1000000, 9999999);
        this.balance = 0;
    }


    //this method will withdraw from the account
    public float withdraw(float val){

        //initialise the newBalance variable with the current balance
        float newBalance = getBalance();

        return newBalance;
    }


    //getters
    public int getAccountNumber(){ 
        return this.accountNumber; 
    }

    public float getBalance(){ 
        return this.balance; 
    }

    public String getAccountHolderName(){ 
        return this.accountHolderName; 
    }

    //setters
    public void setAccountHolderName(String val){
        this.accountHolderName = val;
    }

    public void setBalance(float val){
        this.balance = val;
    }


    
}
