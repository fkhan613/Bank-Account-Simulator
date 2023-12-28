import java.util.Random;

public class BankAccount {

    //define bank account variables
    private int accountNumber;
    private String accountHolderName;
    private float balance;

    //constructor used when creating a brand new account
    BankAccount(String accountHolderName){

        this.accountHolderName = accountHolderName;
        this.accountNumber =  new Random().nextInt(1000000, 9999999);
        this.balance = 0;
    }

    //overloaded contructor for loading data from text file
    BankAccount(String accountHolderName, int accountNumber, float balance){

        this.accountHolderName = accountHolderName;
        this.accountNumber =  accountNumber;
        this.balance = balance;
    }


    //this method will withdraw from the account and return the new balance
    public float withdraw(float val){

        //initialise the currentBalance variable with the current balance
        float currentBalance = getBalance();

        //check if the withdraw amount is greater than the current balance
        if(val > currentBalance){

            System.out.println("Error: Withdraw amount is greater than bank balance");
            return currentBalance;

        } else {

            currentBalance = currentBalance - val;
            setBalance(currentBalance);
        }

        return currentBalance;
    }

    //this method will deposit money into the account and return the new balance
    public float deposit(float val){

        //there isn't much to check here assuming all error catching will be done in the main class
        float currentBalance = getBalance();
        currentBalance = currentBalance + val;
        setBalance(currentBalance);

        return currentBalance;
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

    public void setAccountNumber(int val){
        this.accountNumber = val;
    }
    
}