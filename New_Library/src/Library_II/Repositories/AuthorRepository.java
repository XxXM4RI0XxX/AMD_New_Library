package Library_II.Repositories;

import Library_II.Entities.Author;

import java.util.ArrayList;

public class AuthorRepository {

    private static ArrayList<Author> authors = new ArrayList<>();

    public static void addAuthor(Author author){
        authors.add(author);
    }

    public static Author getAuthor(int AutID) {
        return authors.get(AutID);
    }
    public static ArrayList<Author> getAuthors() {
        return authors;
    }

    public static void printAuthors(){
        if(authors.isEmpty())
            System.out.println(">>>There's no authors here :(");
        else {
            int ID = 1;
            System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.,-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-_");
            System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._-.-`.");
            System.out.printf("§ %2s |%20s%-20s|%6s%-6s|%70s%-70s§\n", "ID", "Aut", "hor", "Birth"," date", "Bo","oks");
            System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
            for (Author author : authors) {
                author.printProfile(ID);
                author.printAuthorBooks();
                ID++;
                System.out.println();
            }
            System.out.println("`------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------'");
        }
    }

    public static void selectAuthor(){
        AuthorRepository.printAuthors();
        System.out.println("If your author isn't in the list, you can cancel with (0)");
    }
    public static void deleteAuthors(int AuID){
        Author delAuthor = AuthorRepository.getAuthor(AuID);
        if(delAuthor.getBooks().isEmpty()) {
            System.out.printf("Author %s %s successfully deleted :(", delAuthor.getProfile().getName(), delAuthor.getProfile().getLastName());
            authors.remove(AuID);
        }
        else{
            System.out.printf(">>> The author %s has books, delete them first...\n",delAuthor.getProfile().getName());
        }
    }

}