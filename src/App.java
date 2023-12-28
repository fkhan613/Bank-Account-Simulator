public class App {
    public static void main(String[] args) throws Exception {

        String userChoice;

        //print menu
        printSignedOutMenu();

        
    }

    private static void printSignedOutMenu(){

        System.out.println("\n\t\t\tWelcome");
        System.out.println("\t\t------------------------\n");

        System.out.println("Please selected one of the following options:\n");
        System.out.println("a. Login \nb. Create new account\nq. Quit\n");
    }
}
