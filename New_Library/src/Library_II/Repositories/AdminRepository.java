package Library_II.Repositories;

import Library_II.Entities.Administrator;

import java.util.ArrayList;

public class AdminRepository {

    public static ArrayList<Administrator> admins = new ArrayList<>();
    public static void addAdministrator(Administrator administrator){admins.add(administrator);}

    public static Administrator getAdmin(int adminID){
        return admins.get(adminID);
    }

    public static void printAdmins(){
        if(admins.isEmpty())
            System.out.println(">>> There's no admins here :(");
        else {
            int ID = 1;
            System.out.println("  ,._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-.-._.-._.-._.-._.-._.-._.-._._");
            System.out.println(",'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._._.-.-`.");
            System.out.printf("§ %2s |%20s%-20s|%6s%-6s|%12s%-11s§\n", "ID", " Ad", "min", "Birth"," date","Permi","ssions");
            System.out.println("§¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯§");
            for (Administrator administrator : admins) {
                administrator.printProfile(ID);
                System.out.print(" "+administrator);
                if (administrator.getPermissions().size()==2)
                    System.out.print("\t\t  ");
                if (administrator.getPermissions().size()==1)
                    System.out.print("\t\t\t\t  ");
                if (administrator.getPermissions().isEmpty())
                    System.out.print("\t\t\t  ");
                System.out.print(" §");
                ID++;
                System.out.println();
            }
            System.out.println("`----------------------------------------------------------------------------------´");
        }
    }

    public static void selectAdmin(){
        AdminRepository.printAdmins();
        System.out.println("If your administrator isn't in the list, you can cancel with (0)");
    }

    public static void deleteAdmins(int adminID){
        Administrator delAdmin = AdminRepository.getAdmin(adminID);
        System.out.printf("Administrator %s %s successfully deleted :(",delAdmin.getProfile().getName(),delAdmin.getProfile().getLastName());
        AdminRepository.admins.remove(delAdmin);
    }

}
