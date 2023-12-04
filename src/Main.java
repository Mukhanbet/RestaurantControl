import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Events events = new Events();
        Admin admin = new Admin("Admin", 123456);
        Manager manager = new Manager("Manager", 123456);
        ArrayList<String> waitersName = new ArrayList<>();
//        System.out.print("Enter your name: ");
//        String userName = scanner.next();
//        System.out.println("Choose your role: \n admin    manager    waiter");
//        String userRole = scanner.next();
//        System.out.print("Enter password: ");
//        int usersPassword = scanner.nextInt();
//
//
//        menu.displayMenu();
//        menu.controlSecond.add("Hello");

//        menu.controlSecond.add("Nur");
//        menu.controlSecond.add("Welcome");
//        menu.controlSecond.add("World");
//        menu.controlSecond.add("Manty");
//        menu.controlSecond.add("Boso");
//        menu.displaySecond();
//        System.out.println("Put the date\nYear|Month|Day");
//        String eventStatus = scanner.nextLine();
        events.markedDays.add("2023 12 12");
//        String status = scanner.nextLine();
        events.statusEvents.add("scheduled,fdvsd,342,fsdc");
        events.displayDate();
        while(true) {
            String getInput = scanner.next();
            if(getInput.equalsIgnoreCase("next")) {
                if(events.calendar.getMonthValue() == 12) {
                    events.calendar = LocalDate.of(events.calendar.getYear() + 1, 1, LocalDate.now().getDayOfMonth());
                } else {
                    events.calendar = LocalDate.of(events.calendar.getYear(), events.calendar.getMonthValue() + 1, LocalDate.now().getDayOfMonth());
                }
                System.out.println("Calendar" + events.calendar);
                events.displayDate();
            } else if (getInput.equalsIgnoreCase("back")) {
                if(events.calendar.getMonthValue() == 1 ) {
                    events.calendar = LocalDate.of(events.calendar.getYear() - 1, 12, LocalDate.now().getDayOfMonth());
                } else {
                    events.calendar = LocalDate.of(events.calendar.getYear(), events.calendar.getMonthValue() - 1, LocalDate.now().getDayOfMonth());
                }
                System.out.println("Calendar" + events.calendar);
                events.displayDate();
            } else if (getInput.equalsIgnoreCase("exit")){
                break;
            } else {
                int day = Integer.parseInt(getInput);
                String selectedTime = events.calendar.getYear() + " " + events.calendar.getMonthValue() + " " + day;
                if(events.markedDays.contains(selectedTime)) {
                    int indexThatDay = events.markedDays.indexOf(selectedTime);
                    String[] splitStatus = events.statusEvents.get(indexThatDay).split(",\\s*", 4);
                    System.out.println("\u001B[91mCancel\u001B[0m\t\t\t\t\t\t\t\t\t\t\u001B[97mChange\u001B[0m\nStatus:\t\t\t\t|\t" + splitStatus[0] + "\nEvent types:\t\t|\t" + splitStatus[1] + "\nNumber of Visitors: |\t" + splitStatus[2] + "\nSelected menu:\t\t|\t" + splitStatus[3] + "\n\t\t\t\t\t\t\t\t\t\t\t <\u001B[92mexit\u001B[0m");
                    getInput = scanner.next();
                    if(getInput.equalsIgnoreCase("cancel")) {
                        events.statusEvents.remove(indexThatDay);
                        events.markedDays.remove(indexThatDay);
                    } else if (getInput.equalsIgnoreCase("change")) {
                        while(true) {
                            System.out.println("<\u001B[92mexit\u001B[0m\t\t\tA\t\t\t\tB\t\t\t\tC\n\t\t\tEvent type | Number of visitors | Menu ");
                            getInput = scanner.next();
                            if(getInput.equalsIgnoreCase("A")) {
                                System.out.println("\u001B[97mEvent type\u001B[0m\n\u001B[91m|\u001B[0m " + splitStatus[1] + " \u001B[91m|\u001B[0m\n");
                                splitStatus[1] = changeEvent(splitStatus[1]);
                                events.statusEvents.set(indexThatDay, splitStatus[0] + "," + splitStatus[1] + "," + splitStatus[2] + "," + splitStatus[3]);
                            } else if (getInput.equalsIgnoreCase("B")) {
                                System.out.println("\u001B[97mNumber of visitors\u001B[0m\n\u001B[91m|\u001B[0m " + splitStatus[2] + " \u001B[91m|\u001B[0m\n");
                                splitStatus[2] = changeEvent(splitStatus[2]);
                                events.statusEvents.set(indexThatDay, splitStatus[0] + "," + splitStatus[1] + "," + splitStatus[2] + "," + splitStatus[3]);
                            } else if (getInput.equalsIgnoreCase("C")) {
                                System.out.println("\u001B[97mMenu\u001B[0m\n\u001B[91m|\u001B[0m " + splitStatus[3] + " \u001B[91m|\u001B[0m\n");
                                menu.displayMenu();
                                splitStatus[3] = changeEvent(splitStatus[3]);
                                events.statusEvents.set(indexThatDay, splitStatus[0] + "," + splitStatus[1] + "," + splitStatus[2] + "," + splitStatus[3]);
                            }
                            if(getInput.equalsIgnoreCase("exit")) {
                                break;
                            }
                        }
                    }
                } else {
                    events.markedDays.add(selectedTime);
                    System.out.println("\u001B[97mEvent type\u001B[0m\t\tA. Свадьба\t\tB. Куран окутуу\t\tC. День рождение\n\t\t\t\tD. Той\t\tE. Индивидуальный предзаказ\t\tF. Корпоративная вечеринка" );
                    String getEventType = scanner.next();
                    System.out.print("\u001B[97mNumber of visitors\u001B[0m ");
                    String getNumberOfVisitors = scanner.next();
                    System.out.print("\u001B[97mMenu\u001B[0m \t\t\t");
                    events.displayMenu();
                    String getMenu = scanner.next();
                    events.statusEvents.add("scheduled," + eventType(getEventType) + "," + getNumberOfVisitors + "," + getMenu);
                }
            }
            events.displayDate();
        }

    }

    public static String eventType(String getEventType) {
        String свадьба = "A";
        String куранОкутуу = "B";
        String денРождения = "C";
        String той = "D";
        String индивидуальныйПредзаказ = "E";
        if (getEventType.equalsIgnoreCase(свадьба)) {
            return "свадьба";
        } else if (getEventType.equalsIgnoreCase(куранОкутуу)) {
            return "Куран окутуу";
        } else if (getEventType.equalsIgnoreCase(денРождения)) {
            return "День Рождения";
        } else if (getEventType.equalsIgnoreCase(той)) {
            return "Той";
        } else if (getEventType.equalsIgnoreCase(индивидуальныйПредзаказ)) {
            return "Индивидуальный предзаказ";
        } else {
            return "Корпоративная вечеринка";
        }
    }

    public static String changeEvent (String strings) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n(\u001B[91mInstructions\u001B[0m) Write down the word(s) you want to change \u001B[91mremove\u001B[0m or \u001B[92madd\u001B[0m at the end, separated by a comma.");
        String getInput = scanner.nextLine();
        String[] split = getInput.split(",\\s*");
        if(split[1].equalsIgnoreCase("add")) {
            strings = strings + " " + split[0];
            return strings;
        } else {
            strings = strings.replaceAll(split[0], "");
            return strings;
        }
    }
}