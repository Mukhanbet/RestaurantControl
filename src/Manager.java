import java.util.ArrayList;

public class Manager {
    ArrayList<String> controlSnacks = new ArrayList<>();
    ArrayList<String> controlFirst = new ArrayList<>();
    ArrayList<String> controlSecond = new ArrayList<>();
    String name;
    int password;
    Manager (String name, Integer password) {
        this.name = name;
        this.password = password;
    }

    void displayControl() {
        System.out.println("Menu\t\t\t\tEvents\t\t\t\tTables");
    }

    void displayMenu() {
        System.out.println("SNACKS\t\t\tFIRST\t\t\tSECOND");
    }
    void displaySnacks() {
        displayDishes(controlSnacks);
    }

    void displayFirst() {
        displayDishes(controlFirst);
    }

    void displaySecond() {
        displayDishes(controlSecond);
    }

    public static void displayDishes(ArrayList<String> menuDishes) {
        System.out.println("Setting");
        for (int i = 0; i < menuDishes.size(); i++) {
            System.out.println(menuDishes.get(i) + "\t");
            if (i % 3 == 0) {
                System.out.println();
            }
        }
    }
}

