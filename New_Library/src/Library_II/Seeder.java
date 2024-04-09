package Library_II;

import Library_II.Entities.*;
import Library_II.Repositories.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Seeder { //Crea objetos para las clases

    static ArrayList<Book> saveBook = new ArrayList<>();
    
    public static void initialize(){

        autoAdmins();
        autoAuthor();
        Client client1 = autoClient1();
        Client client2 = autoClient2();
        Client client3 = autoClient3();
        autoTransaction(client1,client2,client3);
    }

    public static void autoAdmins(){

        String password1 = User.hashString("Art_Gil_1999");
        Profile profile = new Profile("Arturo","Gil Jácome",new Date(99,5,22));
        Administrator superAdmin = new Administrator(profile,"Arturo Gil",password1,true);
        superAdmin.addPermission(Permissions.READ);
        superAdmin.addPermission(Permissions.WRITE);
        superAdmin.addPermission(Permissions.DELETE);
        superAdmin.setAdminLevel();
        UserNameRepository.addUserName("Arturo Gil");

        String password2 = User.hashString("Administration1");
        Profile profile2 = new Profile("Alejandro","Montejano Díaz",new Date(99,5,22));
        Administrator Admin2 = new Administrator(profile2,"AMD",password2,false);
        Admin2.addPermission(Permissions.READ);
        Admin2.addPermission(Permissions.WRITE);
        Admin2.addPermission(Permissions.DELETE);
        Admin2.setAdminLevel();
        UserNameRepository.addUserName("AMD");

        String password3 = User.hashString("Administration2");
        Profile profile3 = new Profile("Baca","Garcia jerome",new Date(99,5,22));
        Administrator Admin3 = new Administrator(profile3,"ADMIN2",password3,false);
        Admin3.addPermission(Permissions.READ);
        Admin3.addPermission(Permissions.WRITE);
        Admin3.setAdminLevel();
        UserNameRepository.addUserName("ADMIN2");

        String password4 = User.hashString("Administration3");
        Profile profile4 = new Profile("Portero","Hernandez Hernandez",new Date(99,5,22));
        Administrator Admin4 = new Administrator(profile4,"ADMIN3",password4,false);
        Admin4.addPermission(Permissions.READ);
        Admin4.setAdminLevel();
        UserNameRepository.addUserName("ADMIN3");

        AdminRepository.admins.add(superAdmin);
        AdminRepository.admins.add(Admin2);
        AdminRepository.admins.add(Admin3);
        AdminRepository.admins.add(Admin4);
    }
    ///////////////////////////CLIENT 1//////////////////////////////
    public static Client autoClient1(){
        String password = User.hashString("ClientOne1");
        Profile profile1 = new Profile("Jafet","Santoyo Algo",new Date(103,Calendar.FEBRUARY,4));
        Client client1 = new Client(profile1,"JSA1",password);
        ClientRepository.addClient(client1);
        UserNameRepository.addUserName("JSA1");

        return client1;
    }
    ///////////////////////////CLIENT 2//////////////////////////////
    public static Client autoClient2(){
        String password = User.hashString("ClientTwo2");
        Profile profile2 = new Profile("Andrea","Duran Martinez",new Date(103,Calendar.SEPTEMBER,2));
        Client client2 = new Client(profile2,"ADM2",password);
        ClientRepository.addClient(client2);
        UserNameRepository.addUserName("ADM2");

        return client2;
    }
    ///////////////////////////CLIENT 3//////////////////////////////
    public static Client autoClient3(){
        String password = User.hashString("ClientThree3");
        Profile profile3 = new Profile("Atiziri","Mancilla Cruz",new Date(103,Calendar.JUNE,5));
        Client client3 = new Client(profile3,"AMC3",password);
        ClientRepository.addClient(client3);
        UserNameRepository.addUserName("AMC3");

        return client3;
    }


    public static void autoAuthor(){

        ///////////////////////////AUTHOR 1//////////////////////////////
        Profile profile1 = new Profile("Gabriel","García Márquez",new Date(27,2,4));
        //Object author
        Author author1 = new Author(profile1);
        //Add new author to Data_Repository
        AuthorRepository.addAuthor(author1);
        //Add books to author and repository
        Book bookA1 = new Book("Cien años de soledad",author1,new Date(67, Calendar.MAY,13),"978-84-204-7183-9");
        author1.addBook(bookA1);
        saveBook.add(bookA1);
        Book bookA2 = new Book("El amor en tiempos de colera",author1,new Date(85,1,1),"978-95-104-4617-1");
        author1.addBook(bookA2);
        saveBook.add(bookA2);
        Book bookA3 = new Book("Crónica de una muerte anunciada",author1,new Date(81,1,1),"978-60-707-2956-0");
        author1.addBook(bookA3);
        saveBook.add(bookA3);

        ///////////////////////////AUTHOR 2//////////////////////////////
        Profile profile2 = new Profile("Antoine","de Saint-Exupéry",new Date(0,Calendar.JUNE,29));
        //Object author
        Author author2 = new Author(profile2);
        //Add new author to Data_Repository
        AuthorRepository.addAuthor(author2);
        //Add books to author and repository
        Book bookB1 = new Book("El principito",author2,new Date(43, Calendar.APRIL,6),"978-60-799-4980-8");
        author2.addBook(bookB1);
        saveBook.add(bookB1);
        Book bookB2 = new Book("Tierra de hombres",author2,new Date(39,3,1),"978-60-714-2034-3");
        author2.addBook(bookB2);
        saveBook.add(bookB2);
        Book bookB3 = new Book("Vuelo nocturno",author2,new Date(30,Calendar.DECEMBER,1),"978-84-154-4182-3");
        author2.addBook(bookB3);
        saveBook.add(bookB3);

        ///////////////////////////AUTHOR 2//////////////////////////////
        Profile profile3 = new Profile("Robert","Fisher",new Date(22,Calendar.SEPTEMBER,21));
        //Object author
        Author author3 = new Author(profile3);
        //Add new author to Data_Repository
        AuthorRepository.addAuthor(author3);
        //Add books to author and repository
        Book bookC1 = new Book("El caballero de la armadura oxidada",author3,new Date(87, Calendar.MAY,1),"978-84-977-7230-3");
        author3.addBook(bookC1);
        saveBook.add(bookC1);
        Book bookC2 = new Book("El regreso del caballero de la armadura oxidada",author3,new Date(10,Calendar.MARCH,31),"978-84-977-7637-0");
        author3.addBook(bookC2);
        saveBook.add(bookC2);
        Book bookC3 = new Book("El gato que encontró a Dios",author3,new Date(103,Calendar.AUGUST,28),"978-84-977-7017-0");
        author3.addBook(bookC3);
        saveBook.add(bookC3);
    }
 
    public static void autoTransaction(Client client1, Client client2, Client client3){
        
        LocalDateTime time1 = LocalDateTime.of(2024, Month.MARCH, 3, 22, 32,05);//6
        LocalDateTime time2 = LocalDateTime.of(2024,Month.MARCH,1,11,15,12);//5
        LocalDateTime time3 = LocalDateTime.of(2023, Month.APRIL, 2, 15, 12,27);//1
        LocalDateTime time4 = LocalDateTime.of(2023, Month.NOVEMBER,3,12,0,0);//3
        LocalDateTime time5 = LocalDateTime.of(2023, Month.AUGUST,31,16,22,47);//2
        LocalDateTime time6 = LocalDateTime.of(2024, Month.JANUARY,1,19,34,01);//4
        
        Transaction transaction1 = new Transaction("BORROW",client1,saveBook.get(3),time3);
        Transaction transaction2 = new Transaction("BORROW",client3,saveBook.get(2),time5);
        Transaction transaction3 = new Transaction("BORROW",client1,saveBook.get(7),time4);// <<
        Transaction transaction4 = new Transaction("RETURN",client1,saveBook.get(3),time6);
        Transaction transaction5 = new Transaction("BORROW",client2,saveBook.get(8),time2);// <<
        Transaction transaction6 = new Transaction("RETURN",client3,saveBook.get(2),time1);
        
        TransactionRepository.addTransaction(transaction1);
        TransactionRepository.addTransaction(transaction2);
        TransactionRepository.addTransaction(transaction3);
        TransactionRepository.addTransaction(transaction4);
        TransactionRepository.addTransaction(transaction5);
        TransactionRepository.addTransaction(transaction6);
        
        Book modBook1 = saveBook.get(7);
        modBook1.modifyIsAvailable(false);
        client1.borrowBook(modBook1);
        
        Book modBook2 = saveBook.get(8);
        modBook2.modifyIsAvailable(false);
        client2.borrowBook(modBook2);
    }

}
