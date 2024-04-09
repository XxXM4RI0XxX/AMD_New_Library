package Library_II.Repositories;

import Library_II.ConsoleReader;

import java.util.ArrayList;

public class UserNameRepository {

    private static ArrayList<String> usernames = new ArrayList<>();

    public static void addUserName(String username){
        usernames.add(username);
    }

    public static void deleteUserName(String username){
        usernames.remove(username);
    }

    public static String checkDuplicateUserName(String username){
        if(usernames.contains(username)) {
            while (usernames.contains(username)) {
                System.out.print("Username alredy exists...\nUsername: ");
                username = ConsoleReader.q.nextLine();
            }
        }
        return username;
    }
}
