import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        //initialise variables
        String userChoice;
        String[] validInputs; 
        User user;

        //print menu
        validInputs = printSignedOutMenu();

        userChoice = handleMenuInput(validInputs);

        switch (userChoice) {
            //they choose to login
            case "a":

                
                break;

            //they choose to create an account
            case "b":

                user = creatAccount();
                

                break;
            
            //they want to quit
            default:
                break;
        }
    }

    //this method will create a user account and store it in the db
    private static User creatAccount(){

        //initialise variables
        String username = "";
        String password = "";
        String confirmedPassword = "";
        Scanner scan = new Scanner(System.in);


        while (true) {

            //we keep re-iterating until user enters valid username
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

        return new User(username, password);
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
