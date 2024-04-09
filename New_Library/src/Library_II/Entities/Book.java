package Library_II.Entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {

    private String isbn;
    private String title;
    private Author Author;
    private Date publishDate;
    private boolean isAvailable; //Book is Available or Borrowed

    public void printBook(int ID){
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = formatter.format(getPublishDate());

        String available;
        if(getIsAvailable())
            available="Available";
        else
            available="Borrowed";

        System.out.printf("§%2s |%-50s|%-40s| %-10s | %-10s |%-10s§",ID,getTitle(),getAuthor().getProfile().getName()+" "+getAuthor().getProfile().getLastName(),date,getIsbn(),available);
    }

    public Book(String title, Author Author, Date publishDate, String isbn){

        this.title=title;
        this.Author=Author;
        this.publishDate=publishDate;
        this.isbn=isbn;
        this.isAvailable=true;
    }

    //Getters|Setters for book values/////////
    public String getTitle() {
        return title;
    }
    public void modifyTitle(String newTitle){title=newTitle;}
    public Author getAuthor() {
        return Author;
    }
    public void modifyAuthor(Author newAuthor){Author=newAuthor;}
    public Date getPublishDate() {
        return publishDate;
    }
    public void modifyPublishDate(int day,int month,int year){
        publishDate= new Date(year,month,day);
    }
    public String getIsbn() {
        return isbn;
    }
    public void modifyIsbn(String newIsbn){isbn=newIsbn;}
    public boolean getIsAvailable(){return isAvailable;}
    public void modifyIsAvailable(boolean status){isAvailable=status;}
    /////////////////////////////////////

}
