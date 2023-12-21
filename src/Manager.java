import java.util.ArrayList;

public class Manager{
    ArrayList<String> controlTables = new ArrayList<>();
    String name;
    int password;
    Manager (String name, Integer password) {
        this.name = name;
        this.password = password;
    }

    void displayMainScreen() {
        System.out.println("Menu\t\t\t\tEvents\t\t\t\tTables");
    }
}

