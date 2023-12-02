import java.time.LocalDate;
import java.util.ArrayList;

public class Events {
    ArrayList<String> markedDays = new ArrayList<>();

    LocalDate calendar = LocalDate.now();

    void displayDate () {
        System.out.println(calendar.getYear() + "\t\t\t\t\t\t\t\t\u001B[32mCreate Events\u001B[0m\n" + calendar.getMonth() + "\n");
        for(int i = 1; i <= calendar.lengthOfMonth(); i++) {
            if(isDateMarked(markedDays, calendar, i)) {
            } else if(calendar.getDayOfMonth() == i) {
                System.out.print("\u001B[31m" + i + "\u001B[0m" + "\t\t\t");
            } else {
                System.out.print(i + "\t\t\t");
            }
            if(i % 5 == 0) {
                System.out.println("\n\n");
            }
        }
    }
    public static boolean isDateMarked(ArrayList<String> markedDays, LocalDate calendar, int calendarDay) {
        int i = 0;
        while(i < markedDays.size()) {
            String thatDay = markedDays.get(i);
            String[] splitThatDay = thatDay.split("\\s+");
            int year = Integer.parseInt(splitThatDay[0]);
            int month = Integer.parseInt(splitThatDay[1]);
            int day = Integer.parseInt(splitThatDay[2]);

            if(calendarDay == day && calendar.getMonthValue() == month && calendar.getYear() == year) {
                if(splitThatDay[3].equalsIgnoreCase("Scheduled")) {
                    System.out.print("\u001B[34m" + calendarDay + "\u001B[0m" + "\t\t\t");
                } else if(splitThatDay[3].equalsIgnoreCase("Cancelled")) {
                    System.out.print("\u001B[90m" + calendarDay + "\u001B[0m" + "\t\t\t");
                } else if(splitThatDay[3].equalsIgnoreCase("finished")){
                    System.out.print("\u001B[35m" + calendarDay + "\u001B[0m" + "\t\t\t");
                } else {
                    System.out.print(calendarDay + "\t\t\t");
                }
                return true;
            }
            i++;
        }
        return false;
    }
}
