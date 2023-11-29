import java.time.LocalDate;
import java.util.ArrayList;

public class Events {
    ArrayList<String> date = new ArrayList<>();

    LocalDate dateTime = LocalDate.now();

    void displayDate () {
        System.out.println(dateTime.getYear() + "\t\t\t\t\t\t\t\t\u001B[32mCreate Events\u001B[0m\n" + dateTime.getMonth() + "\n");
        for(int i = 1; i <= dateTime.lengthOfMonth(); i++) {
            if(dateTime.getDayOfMonth() == i) {
                System.out.print("\u001B[31m" + i + "\u001B[0m" + "\t\t\t");
            } else {
                System.out.print(i + "\t\t\t");
            }
            if(i % 5 == 0) {
                System.out.println("\n\n");
            }
        }
//        System.out.println(date.get(0));
    }
}
