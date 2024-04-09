package Library_II;

import Library_II.Controllers.*;

public class MainLibrary {

    public static void main(String[]args){
        Seeder.initialize();
        System.out.print("\nWelcome to the library! Glad to see you here :].\n");
        Login.loginScreen();
        System.out.print("\nClosing library...");
    }
}
