import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Events events = new Events();
        Admin admin = new Admin("Admin", 123456);
        Manager manager = new Manager("Manager", 123456);
        ArrayList<String> waitersName = new ArrayList<>();
//        System.out.print("Enter your name: ");
//        String userName = scanner.next();
//        System.out.println("Choose your role: \n admin    manager    waiter");
//        String userRole = scanner.next();
//        System.out.print("Enter password: ");
//        int usersPassword = scanner.nextInt();
//
//
//        menu.displayMenu();
//        menu.controlSecond.add("Hello");
//        menu.controlSecond.add("Nur");
//        menu.controlSecond.add("Welcome");
//        menu.controlSecond.add("World");
//        menu.controlSecond.add("Manty");
//        menu.controlSecond.add("Boso");
//        menu.displaySecond();
        System.out.println("Put the date\nYear|Month|Day");
        System.out.println("\n\n\n\n");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        events.displayDate();
        events.dateTime = LocalDate.of(year, month, day);
//        events.displayDate();
//        String date = scanner.nextLine();
//        events.date.add(date);
//        events.displayDate();
        events.displayDate();
    }
}