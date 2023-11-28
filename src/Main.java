import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Admin admin = new Admin("Admin", 123456);
        Manager manager = new Manager("Manager", 123456);
        ArrayList<String> waitersName = new ArrayList<>();
        System.out.print("Enter your name: ");
        String userName = scanner.next();
        System.out.println("Choose your role: \n admin    manager    waiter");
        String userRole = scanner.next();
        System.out.print("Enter password: ");
        int usersPassword = scanner.nextInt();


        menu.displayMenu();
        menu.controlSecond.add("Hello");
        menu.controlSecond.add("Nur");
        menu.controlSecond.add("Welcome");
        menu.controlSecond.add("World");
        menu.controlSecond.add("Manty");
        menu.controlSecond.add("Boso");
        menu.displaySecond();
    }
}