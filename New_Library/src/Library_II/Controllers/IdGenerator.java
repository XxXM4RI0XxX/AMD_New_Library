package Library_II.Controllers;

import java.util.Random;

public class IdGenerator {

    public static String generateId(){  // ID: ASD-123456
        Random ran = new Random();
        String ID="";
        char id;
        for (int i=0; i<10;i++){
            if(i<3){
                int n= ran.nextInt(26)+65;
                id=(char)n;
                ID+=id;
            }else if(i==3){
                ID+='-';
            }
            else{
                int n = ran.nextInt(8)+50;
                id=(char)n;
                ID+=id;
            }
        }
        return ID;
    }

}
