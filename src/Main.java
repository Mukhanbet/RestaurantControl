import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("Admin", 123456);
        Manager manager = new Manager("Manager", 123456);
        ArrayList<String> waitersName = new ArrayList<>();
//        System.out.print("Enter your name: ");
//        String userName = scanner.next();
//        System.out.println("Choose your role: \n admin    manager    waiter");
//        String userRole = scanner.next();
//        System.out.print("Create password: ");
//        int usersPassword = scanner.nextInt();
//        System.out.println("Check if everything is correct \n Enter \"save\"");
//        String save = scanner.next();
//        if(save.equalsIgnoreCase("save")) {
//            if(userRole.equalsIgnoreCase("admin")) {
//                admin.name = userName;
//                admin.password = usersPassword;
//            } else if (userRole.equalsIgnoreCase("manager")) {
//                manager.name = userName;
//                manager.password = usersPassword;
//            } else {
//                waitersName.add(userName);
//            }
//        }

//        System.out.println(admin.name + "\n" + admin.password);
//        System.out.println(manager.name + "\n" + manager.password);
//        manager.displayControl();
//        admin.displayControl();
        admin.displaySecond();
        admin.displayFirst();
        admin.displaySnacks();

    }
}