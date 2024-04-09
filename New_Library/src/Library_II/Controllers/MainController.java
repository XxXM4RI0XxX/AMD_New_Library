package Library_II.Controllers;

import Library_II.ConsoleReader;
import Library_II.Controllers.Filters.BookFilter;
import Library_II.Controllers.Filters.TransactionClientFilter;
import Library_II.Entities.Administrator;
import Library_II.Entities.Client;

public class MainController {

    public static void mainClientMenu(Client client){

        System.out.println("\nWelcome " + client.getProfile().getName() +" "+client.getProfile().getLastName() +" :D");

        boolean flag = true;
        do {
            System.out.println("\n\t  <<<CLIENT MENU>>>");
            System.out.println("-------------------------------");
            System.out.println("1) See Books\n2) See my transactions\n0) Logout");
            char opt = ConsoleReader.q.next().charAt(0);
            // SE PODRIAN USAR CHAR PARA FRENAR QUE EXISTAN FALLAS AL INGRESAR UNA LETRA O CADENA ENVES DE UN NUMERO ENTERO, PERO TIENE LA LIMITACION DE YA NO PODER
            // TENER UN MENU DE MAS DE 11 OPCIONES SI SE USAN NUMEROS ENTEROS, SE PUEDE, PERO SERIA MAS TRABAJO INNECESARIO, MEJOR ATENERSE A LOS TRYCATCH
            switch (opt) {
                case '1':
                    System.out.println("-------------------------------");
                    System.out.println("1) My books\n2) Library books");
                    byte optA=ConsoleReader.q.nextByte();
                    switch (optA){
                        case 1 -> client.printBorrowedBooks();
                        case 2 -> BookFilter.seeBooks();
                        default -> System.out.println("Invalid input...");
                    }
                                        break;
                case '2':
                    TransactionClientFilter.seeClientTransactions(client);
                    break;
                case '0':
                    flag = false;
                    System.out.println("May the force be with you "+client.getProfile().getName()+" :)");
                    break;
                default:
                    System.out.println("Invalid option :o");
            }
        }
        while (flag);
        ConsoleReader.q.nextLine();
    }

    public static void mainAdminMenu(Administrator administrator) {
        System.out.println("\n>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("Welcome " + administrator.getProfile().getName() +" "+ administrator.getProfile().getLastName()+" :D");
        System.out.print("Administrator level: "+administrator.getAdminLevel());
        switch (administrator.getAdminLevel()){
            case 1 -> System.out.println("| READ |");
            case 2 -> System.out.println("| READ ; WRITE |");
            case 3 -> System.out.println("| READ ; WRITE ; DELETE |");
            case 0 -> System.out.println("| No permissions lol |");
        }

        boolean flag = true;
        do {
            System.out.println("\n\t\t<<<ADMIN MENU>>>");
            System.out.println("-------------------------------------");
            System.out.println("\t>>> Operation controls <<<");
            System.out.println("a) Borrow book\nb) Return book\nc) See transactions");
            System.out.println("-------------------------------------");
            System.out.println("\t >>> Administration controls <<<");
            System.out.println("1) Admin books\n2) Admin clients\n3) Admin authors\n0) Logout");
            System.out.println("-------------------------------------");
            System.out.println("x) Admin administrators (only Super Admin)");
            char opt = ConsoleReader.q.next().charAt(0);

            switch (opt) {
                case 'a':
                    OperationControllers.borrowBook();
                    break;
                case 'b':
                    OperationControllers.returnBook();
                    break;
                case 'c':
                    OperationControllers.seeTransactions();
                    break;
                case '1':
                    OptionMenu.adminBookMenu(administrator);
                    break;
                case '2':
                    OptionMenu.adminClientMenu(administrator);
                    break;
                case '3':
                    OptionMenu.adminAuthorMenu(administrator);
                    break;
                case 'x':
                    if(administrator.isSuperAdmin())
                        OptionMenu.superAdminMenu();
                    else System.out.println(">>> Only Super Admin can access !");
                    break;
                case '0':
                    flag = false;
                    System.out.println("May the force be with you "+administrator.getProfile().getName()+" :)");
                    break;
                default:
                    System.out.println("Invalid option :o");
            }
        }while (flag);
        ConsoleReader.q.nextLine();
    }
}
