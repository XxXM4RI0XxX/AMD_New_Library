package Library_II.Controllers;
import Library_II.ConsoleReader;

import java.time.LocalDate;

public class DateConstructor {

    public static int dayConstructor(){
        boolean flag=false;//To let console read data again
        int day;

        do {
            System.out.print("Day:");
            day=ConsoleReader.q.nextInt();
            if (day<32&&day>0)
                flag=true;
            else{
                System.out.println("Invalid day...");
            }
        }while (!flag);

        return day;
    }

    public static int monthConstructor(){
        boolean flag=false;
        int month;
        do{
            System.out.println(">JAN:1|FEB:2|MAR:3|APR:4|MAY:5|JUN:6|JUL:7|AUG:8|SEP:9|OCT:10|NOV:11|DEC:12<");
            System.out.print("Month:");
            month=ConsoleReader.q.nextInt();
            if (month<13&&month>0)
                flag=true;
            else{
                System.out.println("Invalid month...");
            }
        }while (!flag);

        return month-1;
    }
    //Type: 1.Author/Book 2.Client
    public static int yearConstructor(int Type){
        boolean flag=false;
        int year;
        do{
            System.out.print("Year:");
            year=ConsoleReader.q.nextInt();
            if(Type==1){
                if (year<2025&&year>0)
                    flag=true;
                else{
                    System.out.println("Invalid year format...");
                }
            } else {
                if (year<=LocalDate.now().getYear()-18 &&year>=1900)
                    flag=true;
                else{
                    System.out.println("Invalid year (must be someone over 18, and born after 1900)");
                }
            }
        }while (!flag);
        ConsoleReader.q.nextLine();
        return year-1900;
    }
}
