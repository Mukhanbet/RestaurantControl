import java.util.ArrayList;

public class Admin extends Manager{
    ArrayList<String> controlManagers = new ArrayList<>();
    ArrayList<String> controlWaiters = new ArrayList<>();

    Admin(String name, Integer password) {
        super(name, password);
    }

    void displayMainScreen() {
        System.out.println("Menu\t\t\t\tEvents\t\t\t\tTables\n\nUsers\t\t\t\tRestaurant\t\t\tReports");
    }

}
