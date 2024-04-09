package Library_II.Repositories;

import Library_II.Entities.Transaction;

import java.util.ArrayList;

public class TransactionRepository {

    public static ArrayList<Transaction> transactions = new ArrayList<>();

    public static void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }

}
