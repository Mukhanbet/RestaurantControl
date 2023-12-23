import java.util.ArrayList;

public class Manager{
    String name;
    String password;
    Manager (String name, String password) {
        this.name = name;
        this.password = password;
    }

    void displayMainScreen() {
        System.out.println("Menu\t\t\t\tEvents\t\t\t\tTables");
    }
}

