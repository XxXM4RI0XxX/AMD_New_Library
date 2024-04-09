package Library_II.Controllers;

import Library_II.ConsoleReader;
import Library_II.Entities.*;
import Library_II.Repositories.*;

import java.time.LocalDateTime;
import java.util.Date;

public class EntitiesConstructors {

    //////////////////////AUTHORS/////////////////////////////
    public static void authorConstructor() {
        //////////////////////
        // NAME
        System.out.println(">>>Author data<<<");
        System.out.print("Author name: ");
        String name = ConsoleReader.q.nextLine();
        System.out.print("Author last name: ");
        String lastname = ConsoleReader.q.nextLine();
        if(name.isEmpty()||lastname.isEmpty()){
            System.out.println(">>> Invalid author name, try again...");
        }
        else{
        System.out.println("Author birth day(DD/MM/YYYY):");
        /////////////////////
        // BIRTHDAY
        int day = DateConstructor.dayConstructor();
        int month = DateConstructor.monthConstructor();
        int type=1;//Author
        int year = DateConstructor.yearConstructor(type);
        //Creating author profile
        Profile profile = new Profile(name.trim(), lastname.trim(), new Date(year, month, day));
        //Object author
        Author author = new Author(profile);
        //Add new author to Data_Repository
        AuthorRepository.addAuthor(author);
            System.out.println("Author successfully added :D");
        }
    }
    //////////////////////////////////////////////////////

    /////////////////////////BOOKS//////////////////////////////
    public static void bookConstructor() {

        System.out.println(">>>Book data<<<");
        System.out.print("Book title: ");
        String title = ConsoleReader.q.nextLine();
        if(title.isEmpty()){
            System.out.println(">>> Book title is esencial, try again...");
        }
        else{
        AuthorRepository.selectAuthor();
        int autID = ConsoleReader.q.nextInt();

        if (autID > 0 && autID<=AuthorRepository.getAuthors().size()) {
            Author bookAuthor = AuthorRepository.getAuthor(autID-1);
            System.out.println("Publish date(DD/MM/YYYY): ");
            int day = DateConstructor.dayConstructor();
            int month = DateConstructor.monthConstructor();
            int type=1;//Author
            int year = DateConstructor.yearConstructor(type);
            ConsoleReader.q.nextLine();

            String isbn = IsbnConstructor.verifyISBN(1);
            Book book = new Book(title.trim(), bookAuthor, new Date(year, month, day), isbn);

            bookAuthor.addBook(book);

            System.out.println(">>> Book successfully created :D");
        }
        else {
            System.out.println("Invalid input...");
        }
        }
    }
    //////////////////////////////////////////////////////

    //////////////////////CLIENTS/////////////////////////////
    public static void clientConstructor() {
        //////////////////////
        // NAME
        System.out.println(">>>Client data<<<");
        System.out.print("Client name: ");
        String name = ConsoleReader.q.nextLine();
        System.out.print("Client last name: ");
        String lastname = ConsoleReader.q.nextLine();
        if(name.isEmpty()||lastname.isEmpty()){
            System.out.println(">>> Invalid client name, try again...");
        }
        else{
        System.out.println("Client birth day(DD/MM/YYYY):");
        /////////////////////
        // BIRTHDAY
        int day = DateConstructor.dayConstructor();
        int month = DateConstructor.monthConstructor();
        int year = DateConstructor.yearConstructor(2);
        ////////////////////
        //Username and password
        System.out.print("Username: ");
        String username = ConsoleReader.q.nextLine();
        username = UserNameRepository.checkDuplicateUserName(username); //Verificar usuario repetido
        System.out.print("Password: ");
        String password = ConsoleReader.q.nextLine();
        password = User.verifyPasswordFormat(password);//Verificar que la contraseña tenga formato requerido
        //Creating client profile
        Profile profile = new Profile(name.trim(), lastname.trim(), new Date(year, month, day));
        Client client = new Client(profile,username,password);
        //Add new client to Data_Repository
        ClientRepository.addClient(client);
        System.out.println("\n>>> Client successfully added :D");
        }
    }
    //////////////////////////////////////////////////////

    //////////////////////ADMINS/////////////////////////////
    public static void adminConstructor() {
        //////////////////////
        // NAME
        System.out.println(">>>Admin data<<<");
        System.out.print("Admin name: ");
        String name = ConsoleReader.q.nextLine();
        System.out.print("Admin last name: ");
        String lastname = ConsoleReader.q.nextLine();
        if(name.isEmpty()||lastname.isEmpty()){
            System.out.println(">>> Invalid admin name, try again...");
        }
        else{
            System.out.println("Admin birth day(DD/MM/YYYY):");
            /////////////////////
            // BIRTHDAY
            int day = DateConstructor.dayConstructor();
            int month = DateConstructor.monthConstructor();
            int year = DateConstructor.yearConstructor(2);
            ////////////////////
            //Username and password
            System.out.print("Username: ");
            String username = ConsoleReader.q.nextLine();
            username = UserNameRepository.checkDuplicateUserName(username); //Verificar usuario repetido
            System.out.print("Password: ");
            String password = ConsoleReader.q.nextLine();
            password = User.verifyPasswordFormat(password);//Verificar que la contraseña tenga formato requerido
            //Creating admin profile
            Profile profile = new Profile(name.trim(), lastname.trim(), new Date(year, month, day));
            Administrator admin = new Administrator(profile,username,password,false);
            //Setting permissions to new admin
            System.out.println("Admin permission level?\n1] Can only read\n2] Read and write\n3] Read,write and delete");
            byte opt = ConsoleReader.q.nextByte();
            switch (opt){
                case 3 : admin.addPermission(Permissions.DELETE);
                case 2 : admin.addPermission(Permissions.WRITE);
                case 1 : admin.addPermission(Permissions.READ);
            }
            admin.setAdminLevel();
            //Add new admin to Data_Repository
            AdminRepository.addAdministrator(admin);
            UserNameRepository.addUserName(username);
            System.out.println(">>> Administrator successfully added :D");
        }
    }
    //////////////////////////////////////////////////////

    //////////////////////TRANSACTIONS/////////////////////////////
    public static void transactionConstructor(int transType) {
        String transactionType = switch (transType) {
            case 1 -> "BORROW";
            case 2 -> "RETURN";
            default -> "";
        };

        System.out.println("Who's " + transactionType.toLowerCase() + "ing the book?");
        if(transType==1)
            ClientRepository.selectClient();
        else{
        ClientRepository.selectReturnClient();}

        int selClient = ConsoleReader.q.nextInt(),selBook;

        //If wanted to cancel
        if (selClient > 0 && selClient <= ClientRepository.clients.size()) {
            Client client = ClientRepository.getClient(selClient - 1);

                switch (transType) {
                    case 1:
                        if(client.getBorrowedBooks().size()<3) {
                            System.out.println("Choose the book to " + transactionType.toLowerCase());
                            BookRepository.selectBook();
                            selBook = ConsoleReader.q.nextInt();

                            //If wanted to cancel
                            if (selBook > 0 && selBook <= BookRepository.books.size()) {
                                Book book = BookRepository.getBook(selBook - 1);

                                if (book.getIsAvailable()) {
                                    book.modifyIsAvailable(false);

                                    Transaction transaction = new Transaction(transactionType, client, book, LocalDateTime.now());

                                    TransactionRepository.addTransaction(transaction);

                                    client.borrowBook(book);

                                    System.out.println(">>> Book successfully borrowed :D");
                                } else {
                                    System.out.println(">>> Book already borrowed, try selecting another one :]");
                                }
                            }
                            else {
                                System.out.println("Invalid book...");
                            }
                        }
                        else {
                            System.out.println("Client "+client.getProfile().getName() +" has reached the book borrow limit [3], return any to borrow a new one :]");
                        }
                        break;
                    case 2:
                        System.out.println("Choose the book to " + transactionType.toLowerCase());
                        ClientRepository.selectClientBook(client);
                        selBook = ConsoleReader.q.nextInt();

                        //If there's no book to return
                        if (selBook > 0 && selBook < BookRepository.books.size()) {
                            Book book = client.getBorrowedBooks().get(selBook-1);
                            book.modifyIsAvailable(true);

                            Transaction transaction = new Transaction(transactionType, client, book, LocalDateTime.now());
                            TransactionRepository.addTransaction(transaction);

                            client.returnBook(book);

                            System.out.println(">>> Book successfully returned :D ");
                        }
                        else {
                            System.out.println("Invalid book...");
                        }
                }

        }
        else {
            System.out.println("Invalid client...");
        }
    }
}
