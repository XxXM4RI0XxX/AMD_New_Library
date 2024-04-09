package Library_II.Controllers;

import Library_II.ConsoleReader;

public class IsbnConstructor {
// Ensure ISBN is in required format
public static String verifyISBN(int modOpt){
    boolean flag=true;
    String isbn;
    do {
        System.out.println("ISBN(13 digits): ");
        isbn = ConsoleReader.q.nextLine();
        isbn=isbn.trim();
        if(modOpt==1) { // Creation (1)
            if (isbn.length() == 13)
                flag = false;
            else {
                System.out.println("Invalid isbn length...");
            }
        }
        else { // Modification (2)
            if (isbn.length() == 13 || isbn.isEmpty())
                flag = false;
            else {
                System.out.println("Invalid isbn length...");
            }
        }
    }while (flag);

    if(!isbn.isEmpty()){
    isbn=formatIsbn(isbn);}

    return isbn;
}

    //012-34-567-8901-2
    public static String formatIsbn(String isbn){
        String isbn1=isbn.substring(0,3);
        String isbn2=isbn.substring(3,5);
        String isbn3=isbn.substring(5,8);
        String isbn4=isbn.substring(8,12);
        char isbn5=isbn.charAt(12);

        isbn=isbn1+"-".concat(isbn2)+"-".concat(isbn3)+"-".concat(isbn4)+"-"+isbn5;

        return isbn;
    }

}
