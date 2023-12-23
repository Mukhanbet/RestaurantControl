import java.util.ArrayList;

public class Users {

    Restaurant restaurant = new Restaurant();
    public Users (ArrayList<String> restaurant) {
        this.restaurant.restaurantsData = restaurant;
    }
    ArrayList<String> managersData = new ArrayList<>();
    ArrayList<String> waitersData = new ArrayList<>();
    int waitersPassword = 11;

    void displayManagersData () {
        System.out.println("\u001B[0m\n<\u001B[91mexit\t\t\t\t\t\u001B[97mchange\u001B[0m");
        System.out.println("\t\t\t\u001B[92mMANAGERS\u001B[0m\n");
        for(int i = 0; i < managersData.size(); i++) {
            String[] managerData = managersData.get(i).split("\\s+");
            int index = getIndexOfNameRest(restaurant.restaurantsData, managerData[0]);
            if(index != -1) {
                String[] nameRest = restaurant.restaurantsData.get(index).split(",\\s*");
                System.out.println(" Name\t\t\t|\t\u001B[97m" + managerData[0] + "\u001B[0m\n Password\t\t|\t\u001B[94m" + managerData[1] + "\u001B[0m\n Restaurant\t\t|\t\u001B[97m" + nameRest[0] + "\u001B[0m\n");
            } else {
                System.out.println(" Name\t\t\t|\t\u001B[97m" + managerData[0] + "\u001B[0m\n Password\t\t|\t\u001B[94m" + managerData[1] + "\u001B[0m\n Restaurant\t\t|\t\u001B[91m" + "---\u001B[0m\n");
            }
        }
    }

    void displayWaitersData () {
        System.out.println("\u001B[0m\n<\u001B[91mexit\t\t\t\t\t\u001B[97mchange\u001B[0m");
        System.out.println("\t\t\t\u001B[93mWAITERS\u001B[0m\n password - \u001B[97m" + waitersPassword + "\u001B[0m\n");
        for(int i = 0; i < waitersData.size(); i++) {
            String[] waiterData = waitersData.get(i).split("\\s+");
            System.out.println(" Name\t\t\t|\t\u001B[97m" + waiterData[0] + "\u001B[0m\n Salary\t\t\t|\t\u001B[91m" + waiterData[1] + "\u001B[0m\n");
        }
    }

    public static int getIndexOfNameRest (ArrayList<String> restaurant, String managerName) {
        for(int i = 0; i < restaurant.size(); i++) {
            String[] nameRest = restaurant.get(i).split(",\\s*");
            for(String name : nameRest) {
                if(name.contains(managerName)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
