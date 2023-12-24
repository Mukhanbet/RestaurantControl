import java.util.ArrayList;

public class Menu {
    ArrayList<String> controlSnacks = new ArrayList<>();
    ArrayList<String> controlFirst = new ArrayList<>();
    ArrayList<String> controlSecond = new ArrayList<>();

    void displayCategoryMenu() {
        System.out.println("\t\u001B[97mSNACKS\t\tFIRST\t\tSECOND\u001B[0m");
    }
    void displaySnacks() {
        System.out.println("\t\t\t\t\t\t\t\u001B[94mSNACKS\u001B[0m");
        System.out.println("<\u001B[92mexit\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\u001B[97madd\u001B[0m");
        displayDishes(controlSnacks);
    }

    void displayFirst() {
        System.out.println("\t\t\t\t\t\t\t\u001B[94mFIRST\u001B[0m");
        System.out.println("<\u001B[92mexit\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\u001B[97madd\u001B[0m");
        displayDishes(controlFirst);
    }

    void displaySecond() {
        System.out.println("\t\t\t\t\t\t\t\u001B[94mSECOND\u001B[0m");
        System.out.println("<\u001B[92mexit\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\u001B[97madd\u001B[0m");
        displayDishes(controlSecond);
    }
    public static void displayDishes(ArrayList<String> menuDishes) {
        int orderElement = 0;
        while(orderElement < menuDishes.size()) {
            String[] splitDishes = menuDishes.get(orderElement).split("\\s+", 2);
            System.out.print(splitDishes[1] + "\u001B[97m(\u001B[0m\u001B[91m" + splitDishes[0] + "\u001B[0m\u001B[97m)\u001B[0m\t\t\t");
            orderElement++;
            if (orderElement % 3 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }
}
