import java.util.ArrayList;

public class Manager{
    String name;
    String password;
    Manager (String name, String password) {
        this.name = name;
        this.password = password;
    }

    void displayMainScreen() {
        System.out.println("\u001B[91mclose\n\t\t\t\t\u001B[94mMAIN SCREEN\n\n\t\t\t\u001B[91m| \u001B[97mEvents \u001B[91m|  | \u001B[97mMenu \u001B[91m|\u001B[0m\n");
    }
}

