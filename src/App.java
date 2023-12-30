import java.util.Scanner;

public class App {
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

                
                break;

            //they choose to create an account
            case "b":

                break;
            
            //they want to quit
            default:
                break;
        }
    }

    private static 

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

        scan.close();

        return userInput;
    }
}
