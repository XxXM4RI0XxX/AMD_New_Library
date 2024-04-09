package Library_II.Repositories;

import Library_II.Entities.*;

import java.util.ArrayList;

public class BookRepository {

    public static ArrayList<Book> books = new ArrayList<>();

    public static Book getBook(int BookID){

        return books.get(BookID);
    }

    public static void addBook(Book book){
        books.add(book);
    }

    public static void printBooks() {
        if (books.isEmpty())
            System.out.println(">>>No books in inventory :(");
        else {
            int ID = 1;
            System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-_-._");
            System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._-_.-`.");
            System.out.printf("§ %2s|%25s%-25s|%20s%-20s|%6s%-6s|%10s%-9s|%5s%-5s§\n", "ID", "Tit", "le ", "Aut", "hor", "Pub. ", "date", "IS", "BN ", "Sta", "tus");
            System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
            for (Book book : books) {
                book.printBook(ID);
                ID++;
                System.out.println();
            }
            System.out.println("`-------------------------------------------------------------------------------------------------------------------------------------------'");
        }
    }

    public static void selectBook(){
        printBooks();
        System.out.println("If your book isn't in the list, you can cancel with (0)");
    }

    public static void deleteBook(Book delBook){
        books.remove(delBook);
        Author delBookAut = delBook.getAuthor();
        delBookAut.deleteBook(delBook);
        System.out.println(">>> Book "+delBook.getTitle()+" successfully deleted :)");
    }
}
