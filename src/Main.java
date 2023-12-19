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
        standardMenu(menu.controlFirst, menu.controlSecond, menu.controlSnacks) ;
//        System.out.print("Enter your name: ");
//        String userName = scanner.next();
//        System.out.println("Choose your role: \n admin    manager    waiter");
//        String userRole = scanner.next();
//        System.out.print("Enter password: ");
//        int usersPassword = scanner.nextInt();
        while(true) {
            menu.displayCategoryMenu();
            String getInput = scanner.nextLine();
            if(getInput.equalsIgnoreCase("snacks")) {
                while(true) {
                    menu.displaySnacks();
                    getInput = scanner.nextLine();
                    if(isDishContains(menu.controlSnacks, getInput.toUpperCase())) {
                        dishOperation(menu.controlSnacks, getInput);
                    } else if (getInput.equalsIgnoreCase("exit")) {
                        break;
                    } else if (getInput.equalsIgnoreCase("add")) {
                        addingMenuOperation(menu.controlSnacks);
                    }
                }
            } else if (getInput.equalsIgnoreCase("first")) {
                while(true) {
                    menu.displayFirst();
                    getInput = scanner.nextLine();
                    if(isDishContains(menu.controlFirst, getInput.toUpperCase())) {
                        dishOperation(menu.controlFirst, getInput.toUpperCase());
                    } else if(getInput.equalsIgnoreCase("exit")) {
                        break;
                    } else if (getInput.equalsIgnoreCase("add")) {
                        addingMenuOperation(menu.controlFirst);
                    }
                }
            } else if (getInput.equalsIgnoreCase("second")) {
                while(true) {
                    menu.displaySecond();
                    getInput = scanner.nextLine();
                    if(isDishContains(menu.controlSecond, getInput.toUpperCase())) {
                        dishOperation(menu.controlSecond, getInput.toUpperCase());
                    } else if (getInput.equalsIgnoreCase("exit")) {
                        break;
                    } else if (getInput.equalsIgnoreCase("add")) {
                        addingMenuOperation(menu.controlSecond);
                    }
                }
            }
        }

//        events.markedDays.add("2023 12 12");
//        events.statusEvents.add("scheduled,fdvsd,342,fsdc");
//        events.displayDate();
//        while(true) {
//            String getInput = scanner.next();
//            if(getInput.equalsIgnoreCase("next")) {
//                if(events.calendar.getMonthValue() == 12) {
//                    events.calendar = LocalDate.of(events.calendar.getYear() + 1, 1, LocalDate.now().getDayOfMonth());
//                } else {
//                    events.calendar = LocalDate.of(events.calendar.getYear(), events.calendar.getMonthValue() + 1, LocalDate.now().getDayOfMonth());
//                }
//                System.out.println("Calendar" + events.calendar);
//                events.displayDate();
//            } else if (getInput.equalsIgnoreCase("back")) {
//                if(events.calendar.getMonthValue() == 1 ) {
//                    events.calendar = LocalDate.of(events.calendar.getYear() - 1, 12, LocalDate.now().getDayOfMonth());
//                } else {
//                    events.calendar = LocalDate.of(events.calendar.getYear(), events.calendar.getMonthValue() - 1, LocalDate.now().getDayOfMonth());
//                }
//                System.out.println("Calendar" + events.calendar);
//                events.displayDate();
//            } else if (getInput.equalsIgnoreCase("exit")){
//                break;
//            } else {
//                int day = Integer.parseInt(getInput);
//                String selectedTime = events.calendar.getYear() + " " + events.calendar.getMonthValue() + " " + day;
//                if(events.markedDays.contains(selectedTime)) {
//                    int indexThatDay = events.markedDays.indexOf(selectedTime);
//                    String[] splitStatus = events.statusEvents.get(indexThatDay).split(",\\s*", 4);
//                    System.out.println("\u001B[91mCancel\u001B[0m\t\t\t\t\t\t\t\t\t\t\u001B[97mChange\u001B[0m\nStatus:\t\t\t\t|\t" + splitStatus[0] + "\nEvent types:\t\t|\t" + splitStatus[1] + "\nNumber of Visitors: |\t" + splitStatus[2] + "\nSelected menu:\t\t|\t" + splitStatus[3] + "\n\t\t\t\t\t\t\t\t\t\t\t <\u001B[92mexit\u001B[0m");
//                    getInput = scanner.next();
//                    if(getInput.equalsIgnoreCase("cancel")) {
//                        events.statusEvents.remove(indexThatDay);
//                        events.markedDays.remove(indexThatDay);
//                    } else if (getInput.equalsIgnoreCase("change")) {
//                        while(true) {
//                            System.out.println("<\u001B[92exit\u001B[0m\t\t\tA\t\t\t\tB\t\t\t\tC\n\t\t\tEvent type | Number of visitors | Menu ");
//                            getInput = scanner.next();
//                            if(getInput.equalsIgnoreCase("A")) {
//                                System.out.println("\u001B[97mEvent type\u001B[0m\n\u001B[91m|\u001B[0m " + splitStatus[1] + " \u001B[91m|\u001B[0m\n");
//                                splitStatus[1] = changeEvent(splitStatus[1]);
//                                events.statusEvents.set(indexThatDay, splitStatus[0] + "," + splitStatus[1] + "," + splitStatus[2] + "," + splitStatus[3]);
//                            } else if (getInput.equalsIgnoreCase("B")) {
//                                System.out.println("\u001B[97mNumber of visitors\u001B[0m\n\u001B[91m|\u001B[0m " + splitStatus[2] + " \u001B[91m|\u001B[0m\n");
//                                splitStatus[2] = changeEvent(splitStatus[2]);
//                                events.statusEvents.set(indexThatDay, splitStatus[0] + "," + splitStatus[1] + "," + splitStatus[2] + "," + splitStatus[3]);
//                            } else if (getInput.equalsIgnoreCase("C")) {
//                                System.out.println("\u001B[97mMenu\u001B[0m\n\u001B[91m|\u001B[0m " + splitStatus[3] + " \u001B[91m|\u001B[0m\n");
//                                menu.displayMenu();
//                                splitStatus[3] = changeEvent(splitStatus[3]);
//                                events.statusEvents.set(indexThatDay, splitStatus[0] + "," + splitStatus[1] + "," + splitStatus[2] + "," + splitStatus[3]);
//                            }
//                            if(getInput.equalsIgnoreCase("exit")) {
//                                break;
//                            }
//                        }
//                    }
//                } else {
//                    events.markedDays.add(selectedTime);
//                    System.out.println("\u001B[97mEvent type\u001B[0m\t\tA. Свадьба\t\tB. Куран окутуу\t\tC. День рождение\n\t\t\t\tD. Той\t\tE. Индивидуальный предзаказ\t\tF. Корпоративная вечеринка" );
//                    String getEventType = scanner.next();
//                    System.out.print("\u001B[97mNumber of visitors\u001B[0m ");
//                    String getNumberOfVisitors = scanner.next();
//                    System.out.print("\u001B[97mMenu\u001B[0m \t\t\t");
//                    events.displayMenu();
//                    scanner.nextLine();
//                    String getMenu = scanner.nextLine();
//                    events.statusEvents.add("scheduled," + eventType(getEventType) + "," + getNumberOfVisitors + "," + getMenu);
//                }
//            }
//            events.displayDate();
//        }

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
        for(String name : listDishes) {
            if(name.contains(getInput)) {
                return true;
            }
        }
        return false;
    }

    public static int getIndexOfDishes (ArrayList<String> listDishes, String getInput) {
        String name;
        int i = 0;
        while (i < listDishes.size()) {
            name = listDishes.get(i);
            if(name.contains(getInput)) {
                return i;
            }
            i++;
        }
        return -1;
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