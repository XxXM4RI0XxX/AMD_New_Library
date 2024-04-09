package Library_II.Controllers;

import Library_II.ConsoleReader;
import Library_II.Entities.*;
import Library_II.Repositories.*;

public class EntitiesModifier {


    public static void modifyAuthors(int auID){
        Author modAut = AuthorRepository.getAuthor(auID-1);
        Profile modProf = modAut.getProfile();
        System.out.print("New Name: ");
        String NewName = ConsoleReader.q.nextLine();
        System.out.print("New Last Name: ");
        String NewLastName= ConsoleReader.q.nextLine();
        System.out.println("Want to change Birthday?(Y/N)");
        char bOpt=ConsoleReader.q.next().charAt(0);ConsoleReader.q.nextLine();

        if(bOpt=='y'||bOpt=='Y') {
            System.out.println("New Birthday(DD/MM/YYYY)");
            int day = DateConstructor.dayConstructor();
            int month = DateConstructor.monthConstructor();
            int type=1;
            int year = DateConstructor.yearConstructor(type);

            modProf.modifyBirthday(day, month, year);
        }
        //CHECK NEW INFO ISN'T BLANK
        if(!NewName.isEmpty())
            modProf.modifyName(NewName);

        if(!NewLastName.isEmpty())
            modProf.modifyLastName(NewLastName);

        System.out.println("Author successfully modified :D");
    }

    public static void modifyBooks(int bookID){
        Book modBook = BookRepository.getBook(bookID-1);

        if(modBook.getIsAvailable()) {
            System.out.print("New title: ");
            ConsoleReader.q.nextLine();
            String newTitle = ConsoleReader.q.nextLine();

            System.out.println(">> Assign new author");
            AuthorRepository.selectAuthor();
            int newAutID = ConsoleReader.q.nextInt();

            if (newAutID == 0)
                System.out.println(">> Previous author assigned");
            if (newAutID < 0 || newAutID>AuthorRepository.getAuthors().size()) {

                System.out.println("Invalid author input, previous assigned");
            }

            System.out.println("Want to change publish day?(Y/N)");
            char bOpt = ConsoleReader.q.next().charAt(0);

            if (bOpt == 'y' || bOpt == 'Y') {
                System.out.println("New date(DD/MM/YYYY)");
                int day = DateConstructor.dayConstructor();
                int month = DateConstructor.monthConstructor();
                int type = 1;
                int year = DateConstructor.yearConstructor(type);
                modBook.modifyPublishDate(day, month, year);
            } ConsoleReader.q.nextLine();
            String newIsbn = IsbnConstructor.verifyISBN(2);

            //CHECK NEW INFO ISN'T BLANK
            if (!newTitle.isEmpty())
                modBook.modifyTitle(newTitle);

            if (newAutID > 0  && newAutID<AuthorRepository.getAuthors().size()) {
                Author newAuthor = AuthorRepository.getAuthor(newAutID-1);
                modBook.modifyAuthor(newAuthor);
            }

            if (!newIsbn.isEmpty())
                modBook.modifyIsbn(newIsbn);

            System.out.println(">>> Books successfully modified :D");
        }
        else {
            System.out.println("Book <"+modBook.getTitle()+"> is borrowed, wait until it's returned to modify it");
        }

    }

    public static void modifyClients(int cliID){
        Client modCli = ClientRepository.getClient(cliID-1);ConsoleReader.q.nextLine();

        System.out.printf(">>> Client %s \n",modCli.getProfile().getName());
        System.out.println("a) Change client data\nb) Change username\nc) Change password\nx) Cancel");
        char opt = ConsoleReader.q.next().charAt(0);

        switch (opt){
            case 'a' -> {
                Profile modProf = modCli.getProfile();
                System.out.print("New Name: ");
                String NewName = ConsoleReader.q.nextLine();
                System.out.print("New Last Name: ");
                String NewLastName = ConsoleReader.q.nextLine();
                System.out.println("Want to change Birthday?(Y/N)");
                char bOpt = ConsoleReader.q.next().charAt(0);
                ConsoleReader.q.nextLine();

                if (bOpt == 'y' || bOpt == 'Y') {
                    System.out.println("New Birthday(DD/MM/YYYY)");
                    int day = DateConstructor.dayConstructor();
                    int month = DateConstructor.monthConstructor();
                    int year = DateConstructor.yearConstructor(2);

                    modProf.modifyBirthday(day, month, year);
                }
                //CHECK NEW INFO ISN'T BLANK
                if (!NewName.isEmpty())
                    modProf.modifyName(NewName);

                if (!NewLastName.isEmpty())
                    modProf.modifyLastName(NewLastName);

                System.out.println("Client successfully modified :D");
            }
            case 'b' -> {
                System.out.print("New username: ");
                String newUsername = ConsoleReader.q.nextLine();
                newUsername = UserNameRepository.checkDuplicateUserName(newUsername); //Verificar usuario repetido
                modCli.setUsername(newUsername);
                System.out.printf(">>> Username successfully changed |%s|\n",newUsername);
            }
            case 'c' ->{
                String password = ConsoleReader.q.nextLine();
                password = User.verifyPasswordFormat(password);//Verificar que la contraseña tenga formato requerido
                modCli.setPassword(password);
                System.out.println(">>> Password successfully changed");
            }
            default -> System.out.println(">>> Operation canceled...");
        }
    }

    public static void modifyAdmins(int adminID) {
        Administrator modAdmin = AdminRepository.getAdmin(adminID - 1);
        System.out.printf("Admin chosen: %s %s\n",modAdmin.getProfile().getName(),modAdmin.getProfile().getLastName());
        System.out.println("1) Admin info\n2) Admin permissions");
        byte opt = ConsoleReader.q.nextByte();ConsoleReader.q.nextLine();

        switch (opt) {
            // ADMIN INFORMATION /////////////////////////////////////////////////
            case 1 -> {
                System.out.println("<Admin data>");
                System.out.println("a) Change admin data\nb) Change username\nc) Change password\nx) Cancel");
                char opt1 = ConsoleReader.q.next().charAt(0);

                switch (opt1) {
                        case 'a' -> {
                            Profile modProf = modAdmin.getProfile();
                            System.out.print("New Name: ");
                            String NewName = ConsoleReader.q.nextLine();
                            System.out.print("New Last Name: ");
                            String NewLastName = ConsoleReader.q.nextLine();
                            System.out.println("Want to change Birthday?(Y/N)");
                            char bOpt = ConsoleReader.q.next().charAt(0);
                            ConsoleReader.q.nextLine();

                            if (bOpt == 'y' || bOpt == 'Y') {
                                System.out.println("New Birthday(DD/MM/YYYY)");
                                int day = DateConstructor.dayConstructor();
                                int month = DateConstructor.monthConstructor();
                                int year = DateConstructor.yearConstructor(2);

                                modProf.modifyBirthday(day, month, year);
                            }
                            //CHECK NEW INFO ISN'T BLANK
                            if (!NewName.isEmpty())
                                modProf.modifyName(NewName);

                            if (!NewLastName.isEmpty())
                                modProf.modifyLastName(NewLastName);

                            System.out.println("Admin successfully modified :D");
                        }
                        case 'b' -> {
                            System.out.print("New username: ");
                            String newUsername = ConsoleReader.q.nextLine();
                            newUsername = UserNameRepository.checkDuplicateUserName(newUsername); //Verificar usuario repetido
                            modAdmin.setUsername(newUsername);
                            System.out.printf(">>> Username successfully changed |%s|\n",newUsername);
                        }
                        case 'c' -> {
                           String password = ConsoleReader.q.nextLine();
                           password = User.verifyPasswordFormat(password);//Verificar que la contraseña tenga formato requerido
                           modAdmin.setPassword(password);
                           System.out.println(">>> Password successfully changed");
                        }
                        default -> System.out.println(">>> Operation canceled...");
                }
            }
            // ADMIN PERMISSIONS /////////////////////////////////////////////////
            case 2 -> {
                boolean flag = true;

                do {
                    System.out.println("Current admin permissions: "+modAdmin.getPermissions().toString().substring(1,modAdmin.getPermissions().toString().length()-1).replaceAll(","," |"));
                    System.out.println("What permission you want to change?");
                    System.out.println("1) READ\n2) WRITE\n3) DELETE\n0) None");
                    byte optPerm = ConsoleReader.q.nextByte();
                    switch (optPerm) {
                        case 1 -> {
                            if (!modAdmin.getPermissions().contains(Permissions.READ))
                                modAdmin.addPermission(Permissions.READ);
                            else modAdmin.getPermissions().remove(Permissions.READ);
                        }
                        case 2 -> {
                            if (!modAdmin.getPermissions().contains(Permissions.WRITE))
                                modAdmin.addPermission(Permissions.WRITE);
                            else modAdmin.getPermissions().remove(Permissions.WRITE);
                        }
                        case 3 -> {
                            if (!modAdmin.getPermissions().contains(Permissions.DELETE))
                                modAdmin.addPermission(Permissions.DELETE);
                            else modAdmin.getPermissions().remove(Permissions.DELETE);
                        }
                        case 0 -> flag=false;
                    }
                    modAdmin.setAdminLevel();

                }while (flag);
            }
        }
        }

}
