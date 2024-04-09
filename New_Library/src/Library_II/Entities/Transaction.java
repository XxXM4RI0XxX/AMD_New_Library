package Library_II.Entities;

import Library_II.Controllers.IdGenerator;

import java.time.LocalDateTime;

public class Transaction {

    private final String id; //Random generated
    private final String type;//Transaction type, "Borrow" o "Return"
    private final Client client;
    private final Book book;
    private final LocalDateTime date;
    
    
    public Transaction(String type, Client client, Book book,LocalDateTime time){
        this.type=type;
        this.client=client;
        this.book=book;
        this.date= time;
        this.id= IdGenerator.generateId();
    }

    public void printTransaction(int ID){

        String date = getDate().toString();
        String date1 = date.substring(0,10).replaceAll("-","/");
        String date2 = date.substring(11,16);
        date=date1+" ".concat(date2);

        System.out.printf("§%2s |%-10s|%-40s| %-50s | %-10s | %-10s §",ID,getType(),getClient().getProfile().getName()+" "+getClient().getProfile().getLastName(),getBook().getTitle(),date,getId());
    }

    //// GETTERS
    public String getId() {
        return id;
    }
    public String getType() {
        return type;
    }
    public Client getClient() {
        return client;
    }
    public Book getBook() {
        return book;
    }
    public LocalDateTime getDate() {
        return date;
    }

}
