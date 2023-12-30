import java.io.*;
import java.util.HashMap;

abstract class DatabaseController {

    //this method will save the new hashmap of users to the database.txt file
    public static void save(HashMap<Integer, User> users){

        try {
            //create a new file writer
            FileWriter writer = new FileWriter("database.txt");

            //iterate through the hashmap and write each user to the file
            for (User user : users.values()) {
                writer.write(user.getUsername() + "," + user.getPassword() + "," + user.getAccountNumber() + "," + user.getBankAccount().toFileString() + "\n");
            }

            //close the file writer
            writer.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

    }

    public static User login(HashMap<Integer, User> users, int accountNumber, String password){

        User user = null;

        //iterate through the hashmap and check if the account number and password match
        for (User u : users.values()) {
            if(u.getAccountNumber() == accountNumber && u.getPassword().equals(password)){
                user = u;
                break;
            }
        }

        return user;
    }

    public static User register(HashMap<Integer, User> users, String username, String password){

        User user = new User(username, password);
        User exsits = null;

        while(exsits == null){

            //check if the account number in the new user already exsits
            exsits = users.get(user.getAccountNumber());
    
            if (exsits != null) {

                //re-generate a account number and set it to user and their bank account
                user.setAccountNumber(user.generateNewAccountNumber(user.getAccountNumber()));
                user.getBankAccount().setAccountNumber(user.getAccountNumber());
                
            } else{
                break;
            }
        }

        return user;
    }

    public static HashMap<Integer, User> load(){

        //initialise variables
        HashMap<Integer, User> users = new HashMap<Integer, User>();
        String line = "";

        try {
            //create a new file reader
            FileReader reader = new FileReader("database.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);

            //read each line of the file and create a new user object
            while ((line = bufferedReader.readLine()) != null) {

                //split the line into an array
                String[] lineArray = line.split(",");

                //create a new bank account object
                BankAccount bankAccount = new BankAccount(lineArray[0], Integer.parseInt(lineArray[1]), Float.parseFloat(lineArray[2]));

                //create a new user object
                User user = new User(lineArray[0], lineArray[1], Integer.parseInt(lineArray[2]), bankAccount);

                //add the user to the hashmap
                users.put(user.getAccountNumber(), user);
            }

            //close the file reader
            reader.close();

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }

        return users;
    }
    
}