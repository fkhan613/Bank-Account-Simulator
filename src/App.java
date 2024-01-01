import java.util.Scanner;
import java.util.HashMap;

public class App {

    //this loads in all the users from the databse.txt file
    public static HashMap<Integer, User> users = DatabaseController.load();
    public static User loggedInUser;

    public static void main(String[] args) throws Exception {

        //initialise variables
        String userChoice;
        String[] validInputs; 

        //print menu
        validInputs = printSignedOutMenu();

        userChoice = handleMenuInput(validInputs);

        switch (userChoice) {
            //they choose to login
            case "a":
                
                loggedInUser = login();
                break;

            //they choose to create an account
            case "b":

                loggedInUser = createAccount();
                break;
            
            //they want to quit
            default:
                break;
        }

        //if we reach this point, initializing a flag for the game loop is appropriate
        Boolean continueTransactions = true;

        //this will be the main game loop
        while (continueTransactions) {

            validInputs = printSignedInMenu();

            userChoice = handleMenuInput(validInputs);

            switch (userChoice) {
                
                //user wants to deposit
                case "a":

                    performTransaction("deposit");
                    break;

                //user wants to withdraw
                case "b":

                    performTransaction("withdraw");
                    break;
                
                //quit
                default:
                    continueTransactions = false;
                    break;
            }

            
        }
    }

    private static void performTransaction(String type){

        Boolean validInput = false;
        float amount = 0.0f;

        //loop until user enters valid input
        while (!validInput) {

            try{

                System.out.print("PLease enter the amount you want to " + type + ": ");
                amount = new Scanner(System.in).nextFloat();

                validInput = true;

            }catch(Exception e){
                System.out.println("Please only enter numerical values and try again.\n");
                validInput = false;
            }
        }

        switch (type) {
            case "deposit":

                loggedInUser.getBankAccount().deposit(amount);
                break;
            
            case "withdraw":

                loggedInUser.getBankAccount().withdraw(amount);
                break;
        
            default:

                System.out.println("\nGoodbye!\n");
                break;
        }


        //update the user in the hashmap
        users.put(loggedInUser.getAccountNumber(), loggedInUser);

        //save to database
        DatabaseController.save(users);

        System.out.println("\nNew account information: \n" + loggedInUser.toString());

    }

    //this method will login the user
    private static User login(){

        int accountNumber = 0;
        String password = "";
        Boolean loggedIn = false;
        User loggedInUser = null;

        while(!loggedIn){

            Boolean validInput = false;

            while (!validInput) {
                
                try{
    
                    System.out.print("Please enter your account number: ");
                    accountNumber = new Scanner(System.in).nextInt();
    
                    System.out.print("\nPlease enter your password: ");
                    password = new Scanner(System.in).nextLine();

                    //if we got here, it's valid input
                    validInput = true;
    
                }catch(Exception e){
    
                    System.out.println("Please only enter numbers for your account number and try again.");
                }
            }

            //attempt to login
            loggedInUser = DatabaseController.login(users, accountNumber, password);

            if (loggedInUser == null) {

                System.out.println("\nIncorrect account number or password, please try again.");

            } else{

                System.out.println("\nLogged in successfuly!");
                loggedIn = true;
            }

        }

        return loggedInUser;
    }

    //this method will create a user account and store it in the db
    private static User createAccount(){

        //initialise variables
        String username = "";
        String password = "";
        String confirmedPassword = "";
        Scanner scan = new Scanner(System.in);


        while (true) {

            //we keep re-iterating until user enters valid username
            //? Maybe in the future add in duplicate username checking
            if(username.trim().isEmpty()){
                System.out.print("Please enter a valid username: ");
                username = scan.nextLine();
                continue;
            }

            //we keep re-iterating until user enters valid password
            if(password.trim().isEmpty()){
                System.out.print("Please enter a valid password: ");
                password = scan.nextLine();
                continue;
            }

            //we keep re-iterating until user enters confirmed password correctly
            if(!password.trim().equals(confirmedPassword.trim())){
                System.out.print("Please confirm the password correctly: ");
                confirmedPassword = scan.nextLine();
                continue;
            }

            //this break statement is only reached once all valid input is entered
            break;
        }

        //add user to database and hashmap
        User user =  DatabaseController.register(users, username, confirmedPassword);
        users.put(user.getAccountNumber(), user);

        System.out.println("\nYour User Information: \n" + user.toString());

        return user;
    }

    private static String[] printSignedInMenu(){

        String[] validInputs = {"a", "b", "q"}; 

        System.out.println("\t\t\tAll transactions are secure :)");
        System.out.println("\t\t---------------------------------------------\n");

        System.out.println("Please select one of the following options:\n");
        System.out.println("a. Deposit \nb. Withdraw \nq. Log Out\n");
        
        return validInputs;
    }


    //will print the signed out verion of the menu, and return valid inputs
    private static String[] printSignedOutMenu(){

        String[] validInputs = {"a", "b", "q"}; 

        System.out.println("\n\t\t\tWelcome");
        System.out.println("\t\t------------------------\n");

        System.out.println("Please selected one of the following options:\n");
        System.out.println("a. Login \nb. Create new account\nq. Quit\n");

        return validInputs;
    }

    //will handle user input from menu screen
    private static String handleMenuInput(String[] validInputs){

        String userInput = "";
        Scanner scan = new Scanner(System.in);
        Boolean validInput = false;

        //keep looping until the user enters valid input
        while( !validInput ){

            System.out.print("Input: ");
            userInput = scan.next();

            //loop for the lenght of the validInputs array
            for( int i=0; i < validInputs.length; i++ ){

                //break out of loop if valid input found
                if(userInput.equalsIgnoreCase(validInputs[i])){
                    validInput = true;
                    break;
                }
            }
        }

        return userInput.toLowerCase();
    }
}