package Library_II.Controllers;

import Library_II.ConsoleReader;
import Library_II.Entities.*;
import Library_II.Repositories.*;

public class Login {

    public static void loginScreen() {
        boolean outFlag=true;
        do {
            System.out.println("\n\t\t >>>LOGIN<<<");
            String loginUsername = null;
            int type = 0;
            String username;
            Administrator admin = null;
            Client cliente = null;

            //VERIFY USERNAME
            do {
                System.out.println("<Left username blank to exit library system>");
                System.out.print("Username: ");
                username = ConsoleReader.q.nextLine();
                for (Administrator administrator : AdminRepository.admins) {
                    if (administrator.getUsername().equals(username)) {
                        loginUsername = administrator.getUsername();
                        type = 1;
                        admin = administrator;
                    }
                }
                for (Client client : ClientRepository.clients) {
                    if (client.getUsername().equals(username)) {
                        loginUsername = client.getUsername();
                        type = 2;
                        cliente = client;
                    }
                }
                if (loginUsername == null && !username.isEmpty()) {
                    System.out.println("Username not found...");
                }
            } while (loginUsername == null && !username.isEmpty());

            if (!username.isEmpty()) {

                if (type == 1) { //ADMINS
                    //VERIFY PASSWORD
                    boolean flag = true;
                    do {
                        System.out.println("<Left password blank to cancel>");
                        System.out.print("Password: ");
                        String inputPassword = ConsoleReader.q.nextLine();
                        //Check password is the same
                        String userPassword = admin.getPassword();// User password
                        boolean checkPassword = User.checkPassword(inputPassword,userPassword);
                        if (checkPassword) {
                            flag = false;
                            MainController.mainAdminMenu(admin);
                        } else if (inputPassword.isEmpty()){
                            System.out.println(">>> Login canceled");
                            flag=false;
                        }
                        else {
                            System.out.println("Invalid password, try again...");
                        }
                    } while (flag);
                }

                if (type == 2) {//CLIENTS
                    //VERIFY PASSWORD
                    boolean flag = true;
                    do {
                        System.out.println("<Left password blank to cancel>");
                        System.out.print("Password: ");
                        String inputPassword = ConsoleReader.q.nextLine();
                        //Check password is the same
                        String userPassword = cliente.getPassword();// User password
                        boolean checkPassword = User.checkPassword(inputPassword,userPassword);
                        if (checkPassword) {
                            MainController.mainClientMenu(cliente);
                            flag = false;
                        } else if (inputPassword.isEmpty()) {
                            System.out.println(">>> Login canceled");
                            flag = false;
                        } else {
                            System.out.println("Invalid password, try again...");
                        }
                    } while (flag);
                }
            } else {
                outFlag=false;
            }
        }while(outFlag);
    }
}
