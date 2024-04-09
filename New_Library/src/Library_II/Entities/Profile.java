package Library_II.Entities;

import java.util.Date;

public class Profile {

    private String name;
    private String lastName;
    private Date birthdate;

    public Profile(String name, String lastName, Date birthdate){
        this.name=name;
        this.lastName=lastName;
        this.birthdate=birthdate;
    }

    public String getName() {
        return name;
    }
    public void modifyName(String newName){
        name=newName;
    }

    public String getLastName() {
        return lastName;
    }
    public void modifyLastName(String newLastName){
        lastName=newLastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }
    public void modifyBirthday(int day,int month,int year){

        birthdate= new Date(year,month,day);
    }

}
