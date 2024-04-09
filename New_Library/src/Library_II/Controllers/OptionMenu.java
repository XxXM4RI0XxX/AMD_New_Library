package Library_II.Controllers;

import Library_II.ConsoleReader;
import Library_II.Controllers.Filters.BookFilter;
import Library_II.Entities.Administrator;
import Library_II.Entities.Book;
import Library_II.Repositories.*;

public class OptionMenu {
    ////////////////////////////BOOKS/////////////////////////////
    public static void adminBookMenu(Administrator administrator){

        boolean flag=true;

        do {
            System.out.println("\n\t<<<Book admin>>>");
            System.out.println("1) See books\n2) Create book\n3) Modify book\n4) Delete a book\n0) Return");
            int opt=ConsoleReader.q.nextInt();ConsoleReader.q.nextLine();

            switch (opt){
                case 1:
                    if (administrator.getAdminLevel()>=1)
                    BookFilter.seeBooks();
                    else System.out.println(">>> Access deny... haha");
                    break;
                case 2:
                    if(administrator.getAdminLevel()>=2)
                    EntitiesConstructors.bookConstructor();
                    else System.out.println(">>> Access deny (Admin level [2] required)");
                    break;
                case 3:
                    if(administrator.getAdminLevel()==2) {
                        System.out.println("Choose the book you want to modify...");
                        BookRepository.selectBook();
                        int bookID = ConsoleReader.q.nextInt();
                        if (bookID != 0 && bookID <= BookRepository.books.size()) {
                            EntitiesModifier.modifyBooks(bookID);
                        } else {
                            System.out.println("Invalid input...");
                        }
                    }else System.out.println(">>> Access deny (Admin level [2] required)");
                    break;
                case 4:
                    if(administrator.getAdminLevel()==3) {
                        System.out.println("Choose the book you want to delete...");
                        BookRepository.printBooks();
                        System.out.println("0) Cancel");
                        int BookID = ConsoleReader.q.nextInt();
                        if (BookID > 0 && BookID <= BookRepository.books.size()) {
                            Book delBook = BookRepository.getBook(BookID - 1);
                            if (delBook.getIsAvailable())
                                BookRepository.deleteBook(delBook);
                            else {
                                System.out.println(">>> Someone has borrowed the book... wait until the book is returned ._.");
                            }
                        } else {
                            System.out.println("Invalid input...");
                        }
                    } else System.out.println(">>> Access deny (Admin level [3] required)");
                    break;
                case 0:
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid option...");
            }
        }while (flag);
    }
    ////////////////////////////CLIENTS/////////////////////////////
    public static void adminClientMenu(Administrator administrator){

        boolean flag=true;

        do {
            System.out.println("\n\t<<<Clients admin>>>");
            System.out.println("1) See client\n2) Add new client\n3) Modify client\n4) Delete client\n0) Return");
            int opt=ConsoleReader.q.nextInt();ConsoleReader.q.nextLine();

            switch (opt) {
                case 1:
                    if (administrator.getAdminLevel()>=1) {
                        ClientRepository.printClients();
                        System.out.println();
                    } else System.out.println(">>> Access deny... haha");
                    break;
                case 2:
                    if (administrator.getAdminLevel()>=2)
                    EntitiesConstructors.clientConstructor();
                    else System.out.println(">>> Access deny (Admin level [2] required)");
                    break;
                case 3:
                    if (administrator.getAdminLevel()>=2) {
                        System.out.println("Choose the client you want to modify...");
                        ClientRepository.selectClient();
                        int cliID = ConsoleReader.q.nextInt();
                        if (cliID > 0 && cliID <= ClientRepository.clients.size()) {
                            EntitiesModifier.modifyClients(cliID);
                        } else {
                            System.out.println("Invalid input...");
                        }
                    } else System.out.println(">>> Access deny (Admin level [2] required)");
                    break;
                case 4:
                    if (administrator.getAdminLevel()==3) {
                        System.out.println("Choose the client you want to delete...");
                        ClientRepository.printClients();
                        System.out.println("0) Cancel");
                        int CliID = ConsoleReader.q.nextInt();
                        if (CliID > 0 && CliID <= ClientRepository.clients.size()) {
                            ClientRepository.deleteClients(CliID - 1);
                        } else {
                            System.out.println("Invalid input...");
                        }
                    } else System.out.println(">>> Access deny (Admin level [3] required)");
                    break;
                case 0:
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid option...");
            }
        }while (flag);

    }
    ////////////////////////////AUTHORS/////////////////////////////
    public static void adminAuthorMenu(Administrator administrator){

        boolean flag=true;

        do {
            System.out.println("\n\t<<<Authors admin>>>");
            System.out.println("1) See authors\n2) Add new author\n3) Modify authors\n4) Delete author\n0) Return");
            int opt=ConsoleReader.q.nextInt();ConsoleReader.q.nextLine();

            switch (opt) {
                case 1:
                    if (administrator.getAdminLevel()>=1) {
                        AuthorRepository.printAuthors();
                        System.out.println();
                    } else System.out.println(">>> Access deny... haha");
                    break;
                case 2:
                    if (administrator.getAdminLevel()>=2)
                    EntitiesConstructors.authorConstructor();
                    else System.out.println(">>> Access deny (Admin level [2] required)");
                    break;
                case 3:
                    if (administrator.getAdminLevel()>=2) {
                        System.out.println("Choose the author you want to modify...");
                        AuthorRepository.selectAuthor();
                        int AutID = ConsoleReader.q.nextInt();
                        ConsoleReader.q.nextLine();
                        if (AutID > 0 && AutID <= AuthorRepository.getAuthors().size()) {
                            EntitiesModifier.modifyAuthors(AutID);
                        } else {
                            System.out.println("Invalid input...");
                        }
                    } else System.out.println(">>> Access deny (Admin level [2] required)");
                    break;
                case 4:
                    if (administrator.getAdminLevel()==3) {
                        System.out.println("Choose the Author you want to delete...");
                        AuthorRepository.printAuthors();
                        System.out.println("0) Cancel");
                        int autID = ConsoleReader.q.nextInt();
                        if (autID > 0 && autID <= AuthorRepository.getAuthors().size()) {
                            AuthorRepository.deleteAuthors(autID - 1);
                        } else {
                            System.out.println("Invalid input...");
                        }
                    } else System.out.println(">>> Access deny (Admin level [3] required)");
                    break;
                case 0:
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid option...");
            }
        }while (flag);

    }
    ////////////////////////////ADMINS/////////////////////////////
    public static void superAdminMenu() {

        boolean flag=true;

        do {
            System.out.println("\n\t<<<Admin administration>>>");
            System.out.println("1) See admins\n2) Add new admin\n3) Modify admin\n4) Delete admin\n0) Exit");
            int opt=ConsoleReader.q.nextInt();ConsoleReader.q.nextLine();

            switch (opt) {
                case 1:
                    AdminRepository.printAdmins();
                    System.out.println();
                    break;
                case 2:
                    EntitiesConstructors.adminConstructor();
                    break;
                case 3:
                    System.out.println("Choose the admin you want to modify...");
                    AdminRepository.selectAdmin();
                    int adminID=ConsoleReader.q.nextInt();
                    if(adminID>0 && adminID<=AdminRepository.admins.size()){
                        EntitiesModifier.modifyAdmins(adminID);}
                    else {
                        System.out.println("Invalid input...");
                    }
                    break;
                case 4:
                    System.out.println("Choose the admin you want to delete...");
                    AdminRepository.printAdmins();
                    System.out.println("0) Cancel");
                    int AdminID=ConsoleReader.q.nextInt();
                    if(AdminID>0 && AdminID<=AdminRepository.admins.size()){
                        AdminRepository.deleteAdmins(AdminID-1);}
                    else {
                        System.out.println("Invalid input...");
                    }
                    break;
                case 0:
                    flag=false;
                    System.out.println("Pleased to serve you, my lord...");
                    break;
                default:
                    System.out.println("Invalid option...");
            }
        }while (flag);



    }
}
