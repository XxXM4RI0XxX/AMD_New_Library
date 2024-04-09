package Library_II.Entities;

import Library_II.ConsoleReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;

public class User {

    protected Profile profile;
    protected String username;
    protected String password;

    public User(Profile profile,String username, String password){
        this.profile=profile;
        this.username=username;
        this.password=password;
    }

    public void printProfile(int ID){
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String date = formatter.format(profile.getBirthdate());

        System.out.printf("§ %2s |%-40s| %-10s |",ID, profile.getName()+" "+profile.getLastName(),date);
    }

    public Profile getProfile() {
        return profile;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        password = hashString(password);
        this.password = password;
    }

    public static boolean checkPassword(String inputPassword,String userPassword){
        inputPassword = hashString(inputPassword);
        return userPassword.equals(inputPassword);
    }

    public static String hashString(String input) {
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
             // Calculate the SHA-256 hash value
            byte[] hash = md.digest(input.getBytes());

            // Convert byte array to hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            System.err.println("SHA-256 algorithm not found.");
            return null;
        }
    }

    /*
    La contraseña debe:
    - Al menos contener 8 digitos
    - Contener por lo menos un número
    - Contener por lo menos una letra
     */
    public static String verifyPasswordFormat(String password){

        boolean flag1,flag2;

        do {
            flag1=false;flag2=false;
            //Verify is 8 char length
            if (password.length()<8){
                System.out.println(">>> Password needs to be 8 digits length...");
            }
            //Verify has one alphabetic char
            for (int i = 0; i < password.length(); i++) {
                if ((password.charAt(i) > 64 && password.charAt(i) < 91) || (password.charAt(i) > 96 && password.charAt(i) < 123)) {
                    flag1 = true;
                    break;
                }
            }
            if (!flag1) {
                System.out.println(">>> Password needs at least one alphabetic character...");
            }
            //Verify has one number
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) > 47 && password.charAt(i) < 58) {
                    flag2 = true;
                    break;
                }
            }
            if (!flag2) {
                System.out.println(">>> Password needs at least one number...");
            }
            //Retry password if its invalid
            if(password.length()<8||!flag1||!flag2){
                System.out.print("Password: ");
                password = ConsoleReader.q.nextLine();
            }

        }while (password.length()<8||!flag1||!flag2);
        password = hashString(password);
        return password;
    }
}
