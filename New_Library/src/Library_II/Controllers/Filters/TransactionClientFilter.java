package Library_II.Controllers.Filters;

import Library_II.ConsoleReader;
import Library_II.Controllers.DateConstructor;
import Library_II.Entities.*;
import Library_II.Repositories.*;

public class TransactionClientFilter{

    public static void seeClientTransactions(Client client){

        System.out.println("\nWant to filter your transactions?");
        System.out.println("1) Date range\n0) Don't filter, see all");
        int opt = ConsoleReader.q.nextInt();

        switch (opt){
            case 1:
                System.out.println("Year of the transactions...");
                int year = DateConstructor.yearConstructor(1);

                System.out.println("Initial month...");
                int monthI = DateConstructor.monthConstructor();
                System.out.println("End month...");
                int monthE = DateConstructor.monthConstructor();

                if(monthE<monthI)
                    System.out.println("The finish date has to be bigger than the start date");
                else{
                    TransactionFilter.printClientDateRangedTransactions(monthI,year+1900,monthE,client);}
                break;
            case 0:
                printAllClientTransactions(client);
                break;
            default:
                System.out.println("Invalid option...");
        }
    }

    public static void printAllClientTransactions(Client client){
            String name = client.getProfile().getName();
            TransactionFilter.printClientTransactions(name);
    }


}
