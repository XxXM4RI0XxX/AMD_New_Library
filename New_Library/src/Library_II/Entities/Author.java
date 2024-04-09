package Library_II.Entities;

import Library_II.Repositories.BookRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Author {

    private final Profile profile;
    private final ArrayList<Book> books = new ArrayList<>(); //Books written by the authors

    public Author(Profile profile){
        this.profile=profile;
    }
    public Profile getProfile() {
        return profile;
    }
    public ArrayList<Book> getBooks() {
        return books;
    }

    public void printProfile(int ID){
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = formatter.format(profile.getBirthdate());

        System.out.printf("§ %2s |%-40s| %-10s |",ID, profile.getName()+" "+profile.getLastName(),date);
    }

    public void printAuthorBooks(){
        for(Book book:books){
            String pBook=book.getTitle();
            if(pBook.length()>25)
                pBook = pBook.substring(0,25)+"...";

            System.out.print(pBook+", ");
        }
    }

    public void addBook(Book book){
        books.add(book);
        BookRepository.addBook(book);
    }
    public void deleteBook(Book delBook){
        books.remove(delBook);
    }


}