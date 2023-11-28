import java.util.ArrayList;

public class Menu {
    ArrayList<String> controlSnacks = new ArrayList<>();
    ArrayList<String> controlFirst = new ArrayList<>();
    ArrayList<String> controlSecond = new ArrayList<>();

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
//        System.out.println(menuDishes.size());
        int count = 0;
        for (int i = 0; i < menuDishes.size(); i++) {
            System.out.print(menuDishes.get(i) + "\t\t");
            count++;
            if (count % 3 == 0) {
                System.out.println();
            }
        }
    }
}
