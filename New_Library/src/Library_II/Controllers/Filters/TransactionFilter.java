package Library_II.Controllers.Filters;

import Library_II.Entities.Client;
import Library_II.Entities.Transaction;

import static Library_II.Repositories.TransactionRepository.transactions;

public class TransactionFilter {
    ///////////////////////////// ADMIN ////////////////////////////////
    public static void printAllTransactions(){

        if (transactions.isEmpty())
            System.out.println(">>> No transactions made :)");
        else {
            int ID = 1;
            printTransactionTableDesign();
            for (Transaction transaction : transactions) {
                transaction.printTransaction(ID);
                ID++;
                System.out.println();
            }
            printLowerTransactionTableDesign();

        }
    }

    public static void printDateRangedTransactions(int monthS,int year,int monthF){

        if (transactions.isEmpty())
            System.out.println(">>> No transactions made :)");
        else {
            int ID = 1;
            printTransactionTableDesign();
            for (Transaction transaction : transactions) {
                if(transaction.getDate().getYear()==year&&(transaction.getDate().getMonthValue()>=monthS
                &&transaction.getDate().getMonthValue()<=monthF)){
                    transaction.printTransaction(ID);
                    ID++;
                    System.out.println();
                }
            }
            printLowerTransactionTableDesign();
        }

    }

    public static void printBookTransactions(String title){

        if (transactions.isEmpty())
            System.out.println(">>> No transactions made :)");
        else {
            int ID = 1;
            printTransactionTableDesign();
            for (Transaction transaction : transactions) {
                if(transaction.getBook().getTitle().equals(title)) {
                    transaction.printTransaction(ID);
                    System.out.println();
                }
            }
            printLowerTransactionTableDesign();
        }
    }

    public static void printClientTransactions(String name){

        if (transactions.isEmpty())
            System.out.println(">>> No transactions made :)");
        else {
            int ID = 1;
            printTransactionTableDesign();
            for (Transaction transaction : transactions) {
                if(transaction.getClient().getProfile().getName().equals(name)) {
                    transaction.printTransaction(ID);
                    ID++;
                    System.out.println();
                }
            }
            printLowerTransactionTableDesign();
        }
    }


    ///////////////////////////// CLIENT ////////////////////////////////
    public static void printClientDateRangedTransactions(int monthS, int year, int monthF, Client client){

        if (transactions.isEmpty())
            System.out.println(">>> You didn't make any transactions :)");
        else {
            int ID = 1;
            printTransactionTableDesign();
            for (Transaction transaction : transactions) {
                if(transaction.getDate().getYear()==year&&(transaction.getDate().getMonthValue()>=monthS
                        &&transaction.getDate().getMonthValue()<=monthF&&transaction.getClient().equals(client))){
                    transaction.printTransaction(ID);
                    ID++;
                    System.out.println();
                }
            }
            printLowerTransactionTableDesign();
        }

    }

    public static void printClientBookTransactions(String title,Client client){

        if (transactions.isEmpty())
            System.out.println(">>> You don't have transactions for this book :)");
        else {
            int ID = 1;
            printTransactionTableDesign();
            for (Transaction transaction : transactions) {
                if(transaction.getBook().getTitle().equals(title)&&transaction.getClient().equals(client)) {
                    transaction.printTransaction(ID);
                    System.out.println();
                    ID++;
                }
            }
            printLowerTransactionTableDesign();
        }
    }

    ///////////////////////////TABLE DESIGN /////////////////
    public static void printTransactionTableDesign(){
        System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._-._");
        System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._-_.-'`.");
        System.out.printf("§ %2s|%5s%-5s|%20s%-20s|%26s%-26s|%9s%-9s|%5s%-5s§\n", "ID", "Ty", "pe", "Cli", "ent", "Bo", "ok", "Da", "te", "  Tran", "s. ID ");
        System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
    }
    public static void printLowerTransactionTableDesign(){
        System.out.println("`--------------------------------------------------------------------------------------------------------------------------------------------´");
    }
}
