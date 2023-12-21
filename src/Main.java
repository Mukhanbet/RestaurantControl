import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Events events = new Events(menu.controlSnacks, menu.controlFirst, menu.controlSecond, menu);
        Admin admin = new Admin("Admin", 123456);
        Manager manager = new Manager("Manager", 123456);
        ArrayList<String> waitersName = new ArrayList<>();
        standardMenu(menu.controlFirst, menu.controlSecond, menu.controlSnacks) ;
//        System.out.print("Enter your name: ");
//        String userName = scanner.next();
//        System.out.println("Choose your role: \n admin    manager    waiter");
//        String userRole = scanner.next();
//        System.out.print("Enter password: ");
//        int usersPassword = scanner.nextInt();
//        while(true) {
//            menu.displayCategoryMenu();
//            String getInput = scanner.nextLine();
//            if(getInput.equalsIgnoreCase("snacks")) {
//                while(true) {
//                    menu.displaySnacks();
//                    getInput = scanner.nextLine();
//                    if(isDishContains(menu.controlSnacks, getInput.toUpperCase())) {
//                        dishOperation(menu.controlSnacks, getInput);
//                    } else if (getInput.equalsIgnoreCase("exit")) {
//                        break;
//                    } else if (getInput.equalsIgnoreCase("add")) {
//                        addingMenuOperation(menu.controlSnacks);
//                    }
//                }
//            } else if (getInput.equalsIgnoreCase("first")) {
//                while(true) {
//                    menu.displayFirst();
//                    getInput = scanner.nextLine();
//                    if(isDishContains(menu.controlFirst, getInput.toUpperCase())) {
//                        dishOperation(menu.controlFirst, getInput.toUpperCase());
//                    } else if(getInput.equalsIgnoreCase("exit")) {
//                        break;
//                    } else if (getInput.equalsIgnoreCase("add")) {
//                        addingMenuOperation(menu.controlFirst);
//                    }
//                }
//            } else if (getInput.equalsIgnoreCase("second")) {
//                while(true) {
//                    menu.displaySecond();
//                    getInput = scanner.nextLine();
//                    if(isDishContains(menu.controlSecond, getInput.toUpperCase())) {
//                        dishOperation(menu.controlSecond, getInput.toUpperCase());
//                    } else if (getInput.equalsIgnoreCase("exit")) {
//                        break;
//                    } else if (getInput.equalsIgnoreCase("add")) {
//                        addingMenuOperation(menu.controlSecond);
//                    }
//                }
//            }
//        }

        events.displayDate();
        while(true) {
            String getInput = scanner.nextLine();
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
            } else if (0 < Integer.parseInt(getInput) && Integer.parseInt(getInput) < 32) {
                int day = Integer.parseInt(getInput);
                String selectedTime = events.calendar.getYear() + " " + events.calendar.getMonthValue() + " " + day;
                if(events.markedDays.contains(selectedTime)) {
                    while(true) {
                        int indexThatDay = events.markedDays.indexOf(selectedTime);
                        String[] splitStatus = events.statusEvents.get(indexThatDay).split(",\\s*", 6);
                        System.out.println("\u001B[91mCancel\u001B[0m\t\t\t\t\t\t\t\t\t\t\u001B[97mChange\u001B[0m\nStatus:\t\t\t\t|\t" + splitStatus[0] + "\nEvent types:\t\t|\t" + splitStatus[1] + "\nNumber of Visitors: |\t" + splitStatus[2] + "\nSelected menu:\t\t|\t" + splitStatus[5] + "\nTotal price: \t\t|\t" + splitStatus[3] +" (сом)\nService:\t\t\t|\t" + splitStatus[4] + "%\n\t\t\t\t\t\t\t\t\t\t\t <\u001B[92mexit\u001B[0m");
                        getInput = scanner.nextLine();
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
                                    events.statusEvents.set(indexThatDay, splitStatus[0] + "," + splitStatus[1] + "," + splitStatus[2] + "," + splitStatus[3] + "," + splitStatus[4] + "," + splitStatus[5]);
                                } else if (getInput.equalsIgnoreCase("B")) {
                                    System.out.println("\u001B[97mNumber of visitors\u001B[0m\n\u001B[91m|\u001B[0m " + splitStatus[2] + " \u001B[91m|\u001B[0m\n");
                                    splitStatus[2] = changeEvent(splitStatus[2]);
                                    events.statusEvents.set(indexThatDay, splitStatus[0] + "," + splitStatus[1] + "," + splitStatus[2] + "," + splitStatus[3] + "," + splitStatus[4] + "," + splitStatus[5]);
                                } else if (getInput.equalsIgnoreCase("C")) {
                                    events.displayMenu();
                                    System.out.println("\u001B[97mMenu\u001B[0m\n\u001B[91m|\u001B[0m " + splitStatus[5] + " \u001B[91m|\u001B[0m");
                                    splitStatus[5] = changeEvent(splitStatus[5]);
                                    String[] splitChangedMenu = splitStatus[5].split(",\\s*");
                                    int servicePercentage = Integer.parseInt(splitStatus[4]);
                                    int totalPrice = generateTotalPrice(menu.controlSnacks, menu.controlFirst, menu.controlSecond, splitChangedMenu, servicePercentage);
                                    events.statusEvents.set(indexThatDay, splitStatus[0] + "," + splitStatus[1] + "," + splitStatus[2] + "," + totalPrice + "," + splitStatus[4] + "," + splitStatus[5]);
                                }
                                if(getInput.equalsIgnoreCase("exit")) {
                                    scanner.nextLine();
                                    break;
                                }
                            }
                        } else if (getInput.equalsIgnoreCase("exit")) {
                            break;
                        }
                    }
                } else {
                    System.out.println("\u001B[97mEvent type\u001B[0m\t\tA. Свадьба\t\tB. Куран окутуу\t\tC. День рождение\n\t\t\t\tD. Той\t\tE. Индивидуальный предзаказ\t\tF. Корпоративная вечеринка" );
                    String getEventType = scanner.nextLine();
                    System.out.print("\u001B[97mNumber of visitors\u001B[0m: ");
                    String getNumberOfVisitors = scanner.nextLine();
                    events.displayMenu();
                    System.out.println("\n(\u001B[91mInstructions\u001B[0m) Write down the name of dishes separated by a comma.\n");
                    String getSelectDishes = scanner.nextLine();
                    String[] splitSelectedDishes = getSelectDishes.split(",\\s*");
                    System.out.print("Enter service percentage: ");
                    int servicePercentage = scanner.nextInt();
                    scanner.nextLine();
                    int totalPrice = generateTotalPrice(menu.controlSnacks, menu.controlFirst, menu.controlSecond, splitSelectedDishes, servicePercentage);
                    while(true) {
                        System.out.println("Event types:\t\t|\t" + eventType(getEventType) + "\nNumber of Visitors: |\t" + getNumberOfVisitors + "\nSelected menu:\t\t|\t" + getSelectDishes + "\nTotal price:\t\t|\t" + totalPrice + " (сом)\t\nService:\t\t\t|\t" + servicePercentage + "%\n\t\t\t\u001B[91mcancel\u001B[0m\t\t\u001B[92msave\u001B[0m");
                        getInput = scanner.nextLine();
                        if(getInput.equalsIgnoreCase("save")) {
                            events.markedDays.add(selectedTime);
                            events.statusEvents.add("scheduled," + eventType(getEventType) + "," + getNumberOfVisitors + "," + totalPrice + "," + servicePercentage + ","+ getSelectDishes);
                            break;
                        } else if (getInput.equalsIgnoreCase("cancel")) {
                            break;
                        }
                    }
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
//
    public static String changeEvent (String strings) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n(\u001B[91mInstructions\u001B[0m) Write down the word(s) you want to change (\u001B[97mseperated by a comma\u001B[0m) \u001B[91mremove\u001B[0m or \u001B[92madd\u001B[0m at the end, separated by a dot.");
        String getInput = scanner.nextLine();
        String[] split = getInput.split("\\.");
        if(split[1].trim().equalsIgnoreCase("add")) {
            strings = strings + ", " + split[0].toUpperCase();
            return strings;
        } else {
            String[] splitToOrder = split[0].split(",\\s*");
            for (int j = 0; j < splitToOrder.length; j++) {
                strings = strings.replaceAll(splitToOrder[j].toUpperCase(), "");
                String[] splitString = strings.split(",\\s*");
                int i = 0;
                if (splitString.length > 1) {
                    String newMenu = "";
                    while(i < splitString.length ) {
                        if(!splitString[i].isEmpty()) {
                            if (newMenu.isEmpty()) {
                                newMenu += splitString[i];
                            } else {
                                newMenu += ", " + splitString[i];
                            }
                        }
                        i++;
                    }
                    strings = newMenu;
                }
            }
            return strings;
        }
    }

    public static void standardMenu (ArrayList<String> controlFirst, ArrayList<String> controlSecond, ArrayList<String> controlSnacks) {
        String secondDishes = "340 БЕШ БАРМАК, 2500 СТЕЙК, 390 Куурдак, 330 ХИНКАЛИ, 550 ЦЫПЛЕНОК ТАБАКА, 150 ГАН-ФАН, 180 БОСО ЛАГМАН, 150 ПЛОВ, 130 БИФШТЕКС";
        String firstDishes = "180 МАСТАВА, 160 БОРЩ, 190 ЧУЧПАРА, 180 МАМПАР, 170 КУРИНЫЙ СУП, 170 ПЕЛЬМЕНИ, 220 ШОРПО ИЗ БАРАНИНЫ, 220 ШОРПО ИЗ ГОВЯДИНЫ, 200 ОЗГОЧО СУП";
        String snacks = "370 Салат Цезарь, 180 ЛЮЛЯ-КЕБАБ, 495 Куриные крылышки, 490 Брускетта с авокадо, 860 Барбекю-крылышки, 1000 Фруктовые Ассорти, 205 пахлава, 245 чак-чак, 1270 АССОРТИ РЫБНОЕ";
        String[] splitSnacks = snacks.split(",\\s*");
        String[] splitFirst = firstDishes.split(",\\s*");
        String[] splitSecond = secondDishes.split(",\\s*");
        for (int i = 0; i < splitSecond.length; i++) {
            controlSecond.add(splitSecond[i].toUpperCase());
            controlFirst.add(splitFirst[i].toUpperCase());
            controlSnacks.add(splitSnacks[i].toUpperCase());
        }
    }

    public static boolean isDishContains (ArrayList<String> listDishes, String getInput) {
        for(String dishName : listDishes) {
            if(dishName.contains(getInput)) {
                return true;
            }
        }
        return false;
    }

    public static int getIndexOfDishes (ArrayList<String> listDishes, String getInput) {
        String dishName;
        int i = 0;
        while (i < listDishes.size()) {
            dishName = listDishes.get(i);
            if(dishName.contains(getInput)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static int generateTotalPrice (ArrayList<String> listSnacks, ArrayList<String> listFirst, ArrayList<String> listSecond, String[] selectedDishes, int percent) {
        int i = 0;
        int totalPrice = 0;
        for(String dishName : listSnacks) {
            while(i < selectedDishes.length) {
                if(dishName.contains(selectedDishes[i])) {
                    String[] splitDish = dishName.split("\\s+", 2);
                    totalPrice += Integer.parseInt(splitDish[0]);
                }
                i++;
            }
            i = 0;
        }

        for(String dishName : listFirst) {
            while(i < selectedDishes.length) {
                if(dishName.contains(selectedDishes[i])) {
                    String[] splitDish = dishName.split("\\s+", 2);
                    totalPrice += Integer.parseInt(splitDish[0]);
                }
                i++;
            }
            i = 0;
        }

        for(String dishName : listSecond) {
            while(i < selectedDishes.length) {
                if(dishName.contains(selectedDishes[i])) {
                    String[] splitDish = dishName.split("\\s+", 2);
                    totalPrice += Integer.parseInt(splitDish[0]);
                }
                i++;
            }
            i = 0;
        }
        int servicePrice = (totalPrice * percent) / 100;
        totalPrice += servicePrice;
        return totalPrice;
    }

    public static void dishOperation (ArrayList<String> listDishes, String enteredDishes) {
        Scanner scanner = new Scanner(System.in);
        int index = getIndexOfDishes(listDishes, enteredDishes.toUpperCase());
        while(true) {
            String dishes = listDishes.get(index);
            String[] splitDishes = dishes.split("\\s+", 2);
            System.out.println("<\u001B[92mexit\u001B[0m\t\t\u001B[91mdelete\u001B[0m  \u001B[97mchange\u001B[0m\n\t" + splitDishes[1] + "\u001B[97m(\u001B[0m\u001B[91m" + splitDishes[0] + "\u001B[0m\u001B[97m)\u001B[0m");
            String getInput = scanner.nextLine();
            if (getInput.equalsIgnoreCase("exit")) {
                break;
            } else if (getInput.equalsIgnoreCase("delete")) {
                listDishes.remove(index);
                break;
            } else if (getInput.equalsIgnoreCase("change")) {
                while(true) {
                    System.out.print("<\u001B[92mexit\u001B[0m\n\tName: " + splitDishes[1] + "\t\tPrice: " + splitDishes[0] + "\nWhich one you want to change: ");
                    getInput = scanner.nextLine();
                    if(getInput.equalsIgnoreCase("exit")) {
                        break;
                    } else if (getInput.equalsIgnoreCase("name")) {
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        while(true) {
                            System.out.println(splitDishes[1] + " --> \u001B[97m" + newName.toUpperCase() + "\u001B[0m\n\t\t\u001B[97mcancel\u001B[0m\t\u001B[92msave\u001B[0m");
                            getInput = scanner.nextLine();
                            if (getInput.equalsIgnoreCase("cancel")) {
                                break;
                            } else if(getInput.equalsIgnoreCase("save")) {
                                String replacedDishes = dishes.replace(splitDishes[1], newName);
                                listDishes.set(index, replacedDishes.toUpperCase());
                                break;
                            }
                        }
                        if(getInput.equalsIgnoreCase("save")) {
                            break;
                        }
                    } else if (getInput.equalsIgnoreCase("price")) {
                        System.out.print("Enter new price: ");
                        String newPrice = scanner.nextLine();
                        while(true) {
                            System.out.println(splitDishes[0] + "\t-->\t\u001B[97m" + newPrice.toUpperCase() + "\u001B[0m\n\t\t\u001B[97mcancel\u001B[0m\t\u001B[92msave\u001B[0m");
                            getInput = scanner.nextLine();
                            if (getInput.equalsIgnoreCase("cancel")) {
                                break;
                            } else if(getInput.equalsIgnoreCase("save")) {
                                String replacedDishes = dishes.replace(splitDishes[0], newPrice);
                                listDishes.set(index, replacedDishes.toUpperCase());
                                break;
                            }
                        }
                        if(getInput.equalsIgnoreCase("save")) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void addingMenuOperation (ArrayList<String> listDishes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name of new dishes: ");
        String dishesName = scanner.nextLine();
        System.out.print("Price of the new dishes: ");
        String dishesPrice = scanner.nextLine();

        while (true) {
            System.out.println(" \u001B[32mnew\u001B[0m:\t" + dishesName.toUpperCase() + "\u001B[97m(\u001B[0m\u001B[91m" + dishesPrice + "\u001B[0m\u001B[97m)\u001B[0m\n\t\u001B[97mcancel\u001B[0m\t\u001B[92madd\u001B[0m");
            String getInput = scanner.nextLine();
            if(getInput.equalsIgnoreCase("cancel")) {
                break;
            } else if (getInput.equalsIgnoreCase("add")) {
                listDishes.add(dishesPrice + " " + dishesName.toUpperCase());
                break;
            }
        }
    }
}