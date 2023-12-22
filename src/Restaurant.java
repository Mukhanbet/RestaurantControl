import java.util.ArrayList;

public class Restaurant {
    ArrayList<String> restaurantsData = new ArrayList<>();

    void displayAllRestData() {
        for(int i = 0; i < restaurantsData.size(); i++) {
            String[] splitData = restaurantsData.get(i).split(",\\s*");
            System.out.println("\t\t\t\u001B[91m|\u001B[0m \u001B[97m" + splitData[0] + "\u001B[0m \u001B[91m|\u001B[0m\nAddress\t\t\t|\t" + splitData[1] + "\nManager\t\t\t|\t" + splitData[2] + "\nNumber of halls |\t" + splitData[3]);
        }
    }

    void showRestaurants() {
        System.out.println("\t\t\t\t\t\u001B[94mRESTAURANTS\u001B[0m\n\t<\u001B[92mexit\u001B[0m\t\t\t\t\t\t\t\t\t\u001B[97madd\u001B[0m");
        int countOrder = 1;
        for(int i = 0; i < restaurantsData.size(); i++) {
            String[] splitDetail = restaurantsData.get(i).split(",\\s*");
            if(splitDetail[4].equalsIgnoreCase("on")) {
                System.out.print("\t\u001B[92m•\u001B[0m\u001B[97m" + splitDetail[0] + "\u001B[0m\t\t");
            } else {
                System.out.print("\t\u001B[91m•\u001B[0m\u001B[97m" + splitDetail[0] + "\u001B[0m\t\t");
            }
            if(countOrder % 3 == 0) {
                System.out.println("\n");
            }
            countOrder++;
        }
        System.out.println();
    }
}
