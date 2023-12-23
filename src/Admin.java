import java.util.ArrayList;

public class Admin extends Manager{

    Admin(String name, String password) {
        super(name, password);
    }

    void displayMainScreen() {
        System.out.println("\u001B[91mclose\n\t\t\t\t\u001B[94mMAIN SCREEN\n\n\u001B[91m| \u001B[97mRestaurant \u001B[91m|  | \u001B[97mUsers \u001B[91m|  | \u001B[97mEvents \u001B[91m|  | \u001B[97mMenu \u001B[91m|\u001B[0m\n");
    }

}
