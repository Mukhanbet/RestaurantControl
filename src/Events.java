import java.time.LocalDate;
import java.util.ArrayList;

public class Events extends Menu{
    ArrayList<String> markedDays = new ArrayList<>();
    ArrayList<String> statusEvents = new ArrayList<>();

    LocalDate calendar = LocalDate.now();

    void displayDate () {
        System.out.println("\u001B[97m" + calendar.getYear() + "\u001B[0m\t\t\t\t\t\t\t\t<\u001B[91mback\u001B[0m\t\u001B[94mnext\u001B[0m>\n" + "\u001B[91m" + calendar.getMonth() + "\u001B[0m\n");
        for(int i = 1; i <= calendar.lengthOfMonth(); i++) {
            if(isDateMarked(markedDays, statusEvents, calendar, i)) {
            } else if(LocalDate.now().getDayOfMonth() == i && calendar.isEqual(LocalDate.now())) {
                System.out.print("\u001B[31m" + i + "\u001B[0m" + "\t\t\t");
            } else {
                System.out.print(i + "\t\t\t");
            }
            if(i % 5 == 0) {
                System.out.println("\n\n");
            }
        }
        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t <\u001B[92mexit\u001B[0m");
    }
    public static boolean isDateMarked(ArrayList<String> markedDays, ArrayList<String> statusEvents, LocalDate calendar, int calendarDay) {
        int i = 0;
        while(i < markedDays.size()) {
            String thatDay = markedDays.get(i);
            String statusEvent = statusEvents.get(i);
            String[] splitStatus = statusEvent.split(",\\s*");
            String[] splitThatDay = thatDay.split("\\s+");
            int year = Integer.parseInt(splitThatDay[0]);
            int month = Integer.parseInt(splitThatDay[1]);
            int day = Integer.parseInt(splitThatDay[2]);
            if(calendarDay == day && calendar.getMonthValue() == month && calendar.getYear() == year) {
                if (calendar.getDayOfMonth() > calendarDay) {
                    System.out.print("\u001B[35m" + calendarDay + "\u001B[0m" + "\t\t\t");
                } else if(splitStatus[0].equalsIgnoreCase("Scheduled")) {
                    System.out.print("\u001B[94m" + calendarDay + "\u001B[0m" + "\t\t\t");
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
