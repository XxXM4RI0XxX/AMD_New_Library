package Library_II.Repositories;

import Library_II.Entities.Client;

import java.util.ArrayList;

public class ClientRepository {

    public static ArrayList<Client> clients = new ArrayList<>();

    public static void addClient(Client client){clients.add(client);}

    public static Client getClient(int CliID){
        return clients.get(CliID);
    }

    public static void selectClientBook(Client client){
        client.printBorrowedBooks();
        System.out.println("If your client doesn't have any book, cancel with (0)");
    }

    public static void printClients(){
        if(clients.isEmpty())
            System.out.println(">>> There's no clients here :(");
        else {
            int ID = 1;
            System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.,-._.-._.-._.-._.-._.-._.-._.-._.-._.");
            System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.`.");
            System.out.printf("§ %2s |%20s%-20s|%6s%-6s|%45s%-45s§\n", "ID", "Aut", "hor", "Birth"," date", "Bo","oks");
            System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
            for (Client client : clients) {
                client.printProfile(ID);
                client.printClientBooks();
                ID++;
                System.out.println();
            }
            System.out.println("`----------------------------------------------------------------------------------------------------------------------------------------------------'");
        }
    }

    public static void printReturnClients(){
        if(clients.isEmpty())
            System.out.println(">>> There's no clients here :(");
        else {
            int ID = 1;
            System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.,-._.-._.-._.-._.-._.-._.-._.-._.-._.");
            System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.`.");
            System.out.printf("§ %2s |%20s%-20s|%6s%-6s|%45s%-45s§\n", "ID", "Aut", "hor", "Birth"," date", "Bo","oks");
            System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
            for (Client client : clients) {
                if(!client.getBorrowedBooks().isEmpty()) {
                    client.printProfile(ID);
                    client.printClientBooks();
                    ID++;
                    System.out.println();
                }
            }
            System.out.println("`----------------------------------------------------------------------------------------------------------------------------------------------------'");
        }
    }

    public static void selectClient(){
        ClientRepository.printClients();
        System.out.println("If your client isn't in the list, you can cancel with (0)");
    }

    public static void selectReturnClient(){
        ClientRepository.printReturnClients();
        System.out.println("If there's no clients with borrowed books, cancel with (0)");
    }

    public static void deleteClients(int CliID){
        Client delClient = ClientRepository.getClient(CliID);
        if(delClient.getBorrowedBooks().isEmpty())
            clients.remove(CliID);
        else{
            System.out.printf(">>> The client %s has a borrowed book... wait for %s to return it ._.\n",delClient.getProfile().getName(),delClient.getProfile().getName());
        }
    }
}
