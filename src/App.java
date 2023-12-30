import java.util.Scanner;
import java.util.HashMap;

public class App {

    //this loads in all the users from the databse.txt file
    public static HashMap<Integer, User> users = DatabaseController.load();

    public static void main(String[] args) throws Exception {

        //initialise variables
        String userChoice;
        String[] validInputs; 
        User loggedInUser;

        //print menu
        validInputs = printSignedOutMenu();

        userChoice = handleMenuInput(validInputs);

        switch (userChoice) {
            //they choose to login
            case "a":

                
                break;

            //they choose to create an account
            case "b":

                loggedInUser = createAccount();
                break;
            
            //they want to quit
            default:
                break;
        }
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

        return userInput;
    }
}