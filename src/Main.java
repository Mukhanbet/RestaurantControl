import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        Restaurant restaurant = new Restaurant();
        Users users = new Users(restaurant.restaurantsData);
        Events events = new Events(menu.controlSnacks, menu.controlFirst, menu.controlSecond, menu);
        Admin admin = new Admin("Admin", "0");
        Manager manager = new Manager("Manager", "1");
        standardMenu(menu.controlFirst, menu.controlSecond, menu.controlSnacks);
        int countAdminAttempt = 5;
        int countManagerAttempt = 5;

        users.managersData.add("NUR 2004 manager");
        users.managersData.add("ADILET 2002 manager");
        users.managersData.add("KANAT 20 manager");
        restaurant.restaurantsData.add("KHAN, Ankara 28, ADILET, 45, ON");
        users.waitersData.add("ALIBABA 1000");
        users.waitersData.add("MELANA 930");
        users.waitersData.add("HUSEN 500");

        while(true) {
            System.out.println("\u001B[91mclose\n\t\u001B[91m•\u001B[0madmin  \u001B[92m•\u001B[0mmanager  \u001B[93m•\u001B[0mwaiter");
            String getInput = scanner.nextLine();
            clearScreen();
            if("admin".contains(getInput.trim().toLowerCase())) {
//                System.out.println("<\u001B[91mexit\u001B[0m");
                while(countAdminAttempt != 0) {
                    if (isCorrectData(admin.name, admin.password, countAdminAttempt)) {
                        countAdminAttempt = 5;
                        while(true) {
                            admin.displayMainScreen();
                            getInput = scanner.nextLine();
                            if("restaurant".contains(getInput.trim().toLowerCase())) {
                                restaurantFunction(restaurant);
                            } else if ("users".contains(getInput.trim().toLowerCase())) {
                                usersFunction(users);
                            } else if ("events".contains(getInput.trim().toLowerCase())) {
                                eventFunction(events, menu);
                            } else if ("menu".contains(getInput.trim().toLowerCase())) {
                                menuFunction(menu);
                            } else if ("close".contains(getInput.trim().toLowerCase())) {
                                clearScreen();
                                break;
                            }
                            clearScreen();
                        }
                    }
                    if("close".contains(getInput.trim().toLowerCase())) {
                        break;
                    } else {
                        countAdminAttempt--;
                    }
                }
                if(countAdminAttempt == 0) {
                    System.out.println("\t\t\t\t\u001B[91mBLOCKED\u001B[0m");
                }

            } else if ("manager".contains(getInput.trim().toLowerCase())) {
//                System.out.println("<\u001B[91mexit\u001B[0m");
                while(countManagerAttempt != 0) {
                    if (isCorrectData(manager.name, manager.password, countManagerAttempt)) {
                        countManagerAttempt = 5;
                        while(true) {
                            manager.displayMainScreen();
                            getInput = scanner.nextLine();
                            if ("menu".contains(getInput.trim().toLowerCase())) {
                                menuFunction(menu);
                            } else if ("events".contains(getInput.trim().toLowerCase())) {
                                eventFunction(events, menu);
                            } else if ("close".contains(getInput.trim().toLowerCase())) {
                                clearScreen();
                                break;
                            }
                            clearScreen();
                        }
                    }
                    if("close".contains(getInput.trim().toLowerCase())) {
                        break;
                    } else {
                        countManagerAttempt--;
                    }
                }
                if (countManagerAttempt == 0) {
                    System.out.println("\t\t\t\t\u001B[91mBLOCKED\u001B[0m");
                }
            } else if("close".contains(getInput.trim().toLowerCase())) {
                break;
            }
        }
    }

    public static void clearScreen () {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }


    public static void usersFunction(Users users) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            clearScreen();
            System.out.println("<\u001B[91mexit\u001B[0m\n\t\t\t•\u001B[92mMANAGER\u001B[0m\t\t•\u001B[93mWAITER\u001B[0m");
            String getInput = scanner.nextLine();
            if("managers".contains(getInput.trim().toLowerCase())) {
                while(true) {
                    clearScreen();
                    users.displayManagersData();
                    getInput = scanner.nextLine();
                    if("exit".contains(getInput.trim().toLowerCase())) {
                        break;
                    } else if ("change".contains(getInput.trim().toLowerCase())) {
                        while(true) {
                            clearScreen();
                            for (int i = 0; i < users.managersData.size(); i++) {
                                String[] managerData = users.managersData.get(i).split("\\s+");
                                System.out.print("\t\t\u001B[91m| \u001B[97m" + managerData[0] + " \u001B[91m|\u001B[0m");
                            }
                            System.out.println("\n\n\t Whose data do you want to change? ");
                            getInput = scanner.nextLine();
                            if(isContains(users.managersData, getInput.toUpperCase())) {
                                int index = getIndex(users.managersData, getInput.toUpperCase());
                                while(true) {
                                    clearScreen();
                                    String managerData = users.managersData.get(index);
                                    String[] splitManagerData = managerData.split("\\s+");
                                    System.out.println("<\u001B[92mexit\t\t\t\t\t\t\u001B[91mdelete\u001B[0m\n \tName\t\t\t|\t\u001B[97m" + splitManagerData[0] + "\u001B[0m\n \tPassword\t\t|\t\u001B[94m" + splitManagerData[1] + "\u001B[0m");
                                    System.out.println("\n\t\t\u001B[91m| \u001B[97mName \u001B[91m|  | \u001B[97mPassword \u001B[91m|\u001B[0m");
                                    getInput = scanner.nextLine();
                                    if("name".contains(getInput.trim().toLowerCase())) {
                                        clearScreen();
                                        changeUsersData (users.managersData, splitManagerData[0], managerData, index);
                                    } else if ("password".contains(getInput.trim().toLowerCase())) {
                                        clearScreen();
                                        changeUsersData(users.managersData, splitManagerData[1], managerData, index);
                                    } else if ("exit".contains(getInput.trim().toLowerCase())) {
                                        break;
                                    } else if ("delete".contains(getInput.trim().toLowerCase())) {
                                        users.managersData.remove(index);
                                        break;
                                    }
                                }
                            }
                            if("exit".contains(getInput.trim().toLowerCase()) || "delete".contains(getInput.trim().toLowerCase())) {
                                break;
                            }
                        }
                    }
                }
            } else if ("waiter".contains(getInput.trim().toLowerCase())) {
                while(true) {
                    clearScreen();
                    users.displayWaitersData();
                    getInput = scanner.nextLine();
                    if("exit".contains(getInput.trim().toLowerCase())) {
                        break;
                    } else if ("change".contains(getInput.trim().toLowerCase())) {
                        while(true) {
                            clearScreen();
                            System.out.println("  <\u001B[91mexit\n\t\t\u001B[91m| \u001B[97mName \u001B[91m|  | \u001B[97mPassword \u001B[91m|\u001B[0m");
                            getInput = scanner.nextLine();
                            if ("name".contains(getInput.trim().toLowerCase())) {
                                while (true) {
                                    clearScreen();
                                    for (int i = 0; i < users.waitersData.size(); i++) {
                                        String[] waiterData = users.waitersData.get(i).split("\\s+");
                                        System.out.print("\t\t\u001B[91m| \u001B[97m" + waiterData[0] + " \u001B[91m|\u001B[0m");
                                    }
                                    System.out.println("\n\n\t Whose name do you want to change? ");
                                    getInput = scanner.nextLine();
                                    if(isContains(users.waitersData, getInput.toUpperCase())) {
                                        int index = getIndex(users.waitersData, getInput.toUpperCase());
                                        String[] splitWaitersData = users.waitersData.get(index).split("\\s+");
                                        clearScreen();
                                        System.out.println("  Name\n  \u001B[91m| \u001B[97m" + splitWaitersData[0] + " \u001B[91m|\u001B[0m\n");
                                        System.out.print(" New name: ");
                                        String newName = scanner.nextLine();
                                        while(true) {
                                            clearScreen();
                                            System.out.println("\u001B[91m" + splitWaitersData[0] + "\u001B[0m --> \u001B[97m" + newName.toUpperCase() + "\u001B[0m\n\t\t\u001B[97mcancel\u001B[0m\t\u001B[92msave\u001B[0m");
                                            getInput = scanner.nextLine();
                                            if ("save".contains(getInput.trim().toLowerCase())) {
                                                users.waitersData.set(index, newName.toUpperCase() + " " + splitWaitersData[1]);
                                                break;
                                            } else if ("cancel".contains(getInput.trim().toLowerCase())) {
                                                break;
                                            }
                                        }
                                    }
                                    if("save".contains(getInput.trim().toLowerCase()) || "cancel".contains(getInput.trim().toLowerCase())) {
                                        break;
                                    }
                                }
                            } else if ("password".contains(getInput.trim().toLowerCase())) {
                                clearScreen();
                                System.out.print("  Password\n  \u001B[91m| \u001B[97m " + users.waitersPassword + " \u001B[91m|\u001B[0m\n\n New password: ");
                                int newPassword = scanner.nextInt();
                                scanner.nextLine();
                                while(true) {
                                    clearScreen();
                                    System.out.println("\u001B[91m" + users.waitersPassword + "\u001B[0m --> \u001B[97m" + newPassword + "\u001B[0m\n\t\t\u001B[97mcancel\u001B[0m\t\u001B[92msave\u001B[0m");
                                    getInput = scanner.nextLine();
                                    if("save".contains(getInput.trim().toLowerCase())) {
                                        users.waitersPassword = newPassword;
                                        break;
                                    } else if ("cancel".contains(getInput.trim().toLowerCase())) {
                                        break;
                                    }
                                }
                            } else if ("exit".contains(getInput.trim().toLowerCase())) {
                                break;
                            }
                        }
                    }
                }
            } else if ("exit".contains(getInput.trim().toLowerCase())) {
                break;
            }
        }
    }
    public static void menuFunction (Menu menu) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            clearScreen();
            System.out.println("<\u001B[91mexit\u001B[0m");
            menu.displayCategoryMenu();
            String getInput = scanner.nextLine();
            if("snacks".contains(getInput.trim().toLowerCase())) {
                while(true) {
                    clearScreen();
                    menu.displaySnacks();
                    getInput = scanner.nextLine();
                    if(isContains(menu.controlSnacks, getInput.toUpperCase())) {
                        dishOperation(menu.controlSnacks, getInput);
                    } else if ("exit".contains(getInput.trim().toLowerCase())) {
                        break;
                    } else if ("add".contains(getInput.trim().toLowerCase())) {
                        addingMenuOperation(menu.controlSnacks);
                    }
                }
            } else if ("first".contains(getInput.trim().toLowerCase())) {
                while(true) {
                    clearScreen();
                    menu.displayFirst();
                    getInput = scanner.nextLine();
                    if(isContains(menu.controlFirst, getInput.toUpperCase())) {
                        dishOperation(menu.controlFirst, getInput.toUpperCase());
                    } else if("exit".contains(getInput.trim().toLowerCase())) {
                        break;
                    } else if ("add".contains(getInput.trim().toLowerCase())) {
                        addingMenuOperation(menu.controlFirst);
                    }
                }
            } else if ("second".contains(getInput.trim().toLowerCase())) {
                while(true) {
                    clearScreen();
                    menu.displaySecond();
                    getInput = scanner.nextLine();
                    if(isContains(menu.controlSecond, getInput.toUpperCase())) {
                        dishOperation(menu.controlSecond, getInput.toUpperCase());
                    } else if ("exit".contains(getInput.trim().toLowerCase())) {
                        break;
                    } else if ("add".contains(getInput.trim().toLowerCase())) {
                        addingMenuOperation(menu.controlSecond);
                    }
                }
            } else if ("exit".contains(getInput.trim().toLowerCase())) {
                break;
            }
        }
    }


    public static void eventFunction (Events events, Menu menu) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            clearScreen();
            System.out.println("  <\u001B[91mexit\n\t\t\u001B[91m| \u001B[97mEvents \u001B[91m|  | \u001B[97mCalendar \u001B[91m|\u001B[0m");
            String getInput = scanner.nextLine();
            if("events".contains(getInput.trim().toLowerCase())) {
                while(true) {
                    clearScreen();
                    events.displayEvents();
                    getInput = scanner.nextLine();
                    if("exit".contains(getInput.trim().toLowerCase())) {
                        break;
                    }
                }
            } else if ("calendar".contains(getInput.trim().toLowerCase())) {
                events.displayDate();
                while(true) {
                    getInput = scanner.nextLine();
                    if("next".contains(getInput.trim().toLowerCase())) {
                        if(events.calendar.getMonthValue() == 12) {
                            events.calendar = LocalDate.of(events.calendar.getYear() + 1, 1, LocalDate.now().getDayOfMonth());
                        } else {
                            events.calendar = LocalDate.of(events.calendar.getYear(), events.calendar.getMonthValue() + 1, LocalDate.now().getDayOfMonth());
                        }
                        System.out.println("Calendar" + events.calendar);
                        events.displayDate();
                    } else if ("back".contains(getInput.trim().toLowerCase())) {
                        if(events.calendar.getMonthValue() == 1 ) {
                            events.calendar = LocalDate.of(events.calendar.getYear() - 1, 12, LocalDate.now().getDayOfMonth());
                        } else {
                            events.calendar = LocalDate.of(events.calendar.getYear(), events.calendar.getMonthValue() - 1, LocalDate.now().getDayOfMonth());
                        }
                        System.out.println("Calendar" + events.calendar);
                        events.displayDate();
                    } else if ("exit".contains(getInput.trim().toLowerCase())) {
                        break;
                    } else if (0 < Integer.parseInt(getInput) && Integer.parseInt(getInput) < 32) {
                        int day = Integer.parseInt(getInput);
                        String selectedTime = events.calendar.getYear() + " " + events.calendar.getMonthValue() + " " + day;
                        if(events.markedDays.contains(selectedTime)) {
                            while(true) {
                                clearScreen();
                                int indexThatDay = events.markedDays.indexOf(selectedTime);
                                String[] splitStatus = events.statusEvents.get(indexThatDay).split(",\\s*", 6);
                                System.out.println("<\u001B[92mexit\t\t\t\t\t\t\t\u001B[91mdelete\t\u001B[97mchange\u001B[0m\nStatus:\t\t\t\t|\t" + splitStatus[0] + "\nEvent type:\t\t\t|\t" + splitStatus[1] + "\nVisitors: \t\t\t|\t" + splitStatus[2] + "\nSelected menu:\t\t|\t" + splitStatus[5] + "\nTotal price: \t\t|\t" + splitStatus[3] +" (сом)\nService:\t\t\t|\t" + splitStatus[4] + "%");
                                getInput = scanner.nextLine();
                                if("delete".contains(getInput.trim().toLowerCase())) {
                                    events.statusEvents.remove(indexThatDay);
                                    events.markedDays.remove(indexThatDay);
                                    break;
                                } else if ("change".contains(getInput.trim().toLowerCase())) {
                                    while(true) {
                                        clearScreen();
                                        System.out.println("<\u001B[92mexit\n\t\t\u001B[91m| \u001B[97mStatus \u001B[91m|  | \u001B[97mTypes \u001B[91m|  | \u001B[97mVisitors \u001B[91m|  | \u001B[97mMenu \u001B[91m|  | \u001B[97mPrice \u001B[91m|  | \u001B[97mService \u001B[91m|\u001B[0m");
                                        getInput = scanner.nextLine();
                                        if ("status".contains(getInput.trim().toLowerCase())) {
                                            clearScreen();
                                            System.out.println("\u001B[97mStatus\u001B[0m\n\u001B[91m|\u001B[0m " + splitStatus[0] + " \u001B[91m|\u001B[0m");
                                            System.out.println("\t\t\t•\u001B[94mscheduled\u001B[0m\t\t•\u001B[35mcompleted\u001B[0m");
                                            getInput = scanner.nextLine();
                                            if("scheduled".contains(getInput.trim().toLowerCase())) {
                                                events.statusEvents.set(indexThatDay, "scheduled" + "," + splitStatus[1] + "," + splitStatus[2] + "," + splitStatus[3] + "," + splitStatus[4] + "," + splitStatus[5]);
                                            } else if ("completed".contains(getInput.trim().toLowerCase())) {
                                                events.statusEvents.set(indexThatDay, "completed" + "," + splitStatus[1] + "," + splitStatus[2] + "," + splitStatus[3] + "," + splitStatus[4] + "," + splitStatus[5]);
                                            }
                                        } else if("types".contains(getInput.trim().toLowerCase())) {
                                            clearScreen();
                                            System.out.println("\u001B[97mType\u001B[0m\n\u001B[91m|\u001B[0m " + splitStatus[1] + " \u001B[91m|\u001B[0m\n");
                                            System.out.println("\t\t\t\t\t\t\t\u001B[94mEVENT TYPE\u001B[0m\n\t\u001B[97mA\u001B[0m \u001B[90mСвадьба\t\t\u001B[97mB\u001B[0m \u001B[90mКуран окутуу\t\t\t\t\t\u001B[97mC\u001B[0m \u001B[90mДень рождение\n\t\u001B[97mD\u001B[0m \u001B[90mТой\t\t\t\u001B[97mE\u001B[0m \u001B[90mИндивидуальный предзаказ\t\t\u001B[97mF\u001B[0m \u001B[90mКорпоративная вечеринка\u001B[0m" );
                                            getInput = scanner.nextLine();
                                            splitStatus[1] = eventType(getInput);
                                            events.statusEvents.set(indexThatDay, splitStatus[0] + "," + splitStatus[1] + "," + splitStatus[2] + "," + splitStatus[3] + "," + splitStatus[4] + "," + splitStatus[5]);
                                        } else if ("visitors".contains(getInput.trim().toLowerCase())) {
                                            clearScreen();
                                            System.out.println("\u001B[97mVisitors\u001B[0m\n\u001B[91m|\u001B[0m " + splitStatus[2] + " \u001B[91m|\u001B[0m\n");
                                            String newAmount = scanner.nextLine();
                                            while(true) {
                                                clearScreen();
                                                System.out.println(splitStatus[2] + " --> \u001B[97m" + newAmount + "\u001B[0m\n\t\t\u001B[97mcancel\u001B[0m\t\u001B[92msave\u001B[0m");
                                                getInput = scanner.nextLine();
                                                if("cancel".contains(getInput.toLowerCase())) {
                                                    break;
                                                } else if ("save".contains(getInput.toLowerCase())) {
                                                    splitStatus[2] = newAmount;
                                                    events.statusEvents.set(indexThatDay, splitStatus[0] + "," + splitStatus[1] + "," + splitStatus[2] + "," + splitStatus[3] + "," + splitStatus[4] + "," + splitStatus[5]);
                                                    break;
                                                }
                                            }
                                        } else if ("menu".contains(getInput.trim().toLowerCase())) {
                                            clearScreen();
                                            events.displayMenu();
                                            System.out.println("\u001B[97mMenu\u001B[0m\n\u001B[91m|\u001B[0m " + splitStatus[5] + " \u001B[91m|\u001B[0m");
                                            splitStatus[5] = changeEvent(splitStatus[5]);
                                            String[] splitChangedMenu = splitStatus[5].split(",\\s*");
                                            int servicePercentage = Integer.parseInt(splitStatus[4]);
                                            int totalPrice = generateTotalPrice(menu.controlSnacks, menu.controlFirst, menu.controlSecond, splitChangedMenu, servicePercentage);
                                            events.statusEvents.set(indexThatDay, splitStatus[0] + "," + splitStatus[1] + "," + splitStatus[2] + "," + totalPrice + "," + splitStatus[4] + "," + splitStatus[5]);
                                        } else if ("price".contains(getInput.trim().toLowerCase())) {


                                        } else if ("service".contains(getInput.trim().toLowerCase())) {
                                            System.out.println("\u001B[97mService\u001B[0m\n\u001B[91m|\u001B[0m " + splitStatus[4] + " \u001B[91m|\u001B[0m\n");
                                        }
                                        if("exit".contains(getInput.trim().toLowerCase())) {
                                            break;
                                        }
                                    }
                                } else if ("exit".contains(getInput.trim().toLowerCase())) {
                                    break;
                                }
                            }
                        } else {
                            clearScreen();
                            System.out.println("\t\t\t\t\t\t\t\u001B[94mEVENT TYPE\u001B[0m\n\t\u001B[97mA\u001B[0m \u001B[90mСвадьба\t\t\u001B[97mB\u001B[0m \u001B[90mКуран окутуу\t\t\t\t\t\u001B[97mC\u001B[0m \u001B[90mДень рождение\n\t\u001B[97mD\u001B[0m \u001B[90mТой\t\t\t\u001B[97mE\u001B[0m \u001B[90mИндивидуальный предзаказ\t\t\u001B[97mF\u001B[0m \u001B[90mКорпоративная вечеринка\u001B[0m" );
                            String getEventType = scanner.nextLine();
                            clearScreen();
                            System.out.print("\u001B[97mNumber of visitors\u001B[0m: ");
                            String getNumberOfVisitors = scanner.nextLine();
                            clearScreen();
                            events.displayMenu();
                            System.out.println("\n(\u001B[91mInstructions\u001B[0m) Write down the name of dishes separated by a comma.\n");
                            String getSelectDishes = scanner.nextLine();
                            String[] splitSelectedDishes = getSelectDishes.trim().split(",\\s*");
                            clearScreen();
                            System.out.print("Enter service percentage: ");
                            int servicePercentage = scanner.nextInt();
                            scanner.nextLine();
                            int totalPrice = generateTotalPrice(menu.controlSnacks, menu.controlFirst, menu.controlSecond, splitSelectedDishes, servicePercentage);
                            while(true) {
                                clearScreen();
                                System.out.println("Time\t\t\t\t|\t" + selectedTime + "\nEvent types\t\t\t|\t" + eventType(getEventType) + "\nNumber of Visitors\t|\t" + getNumberOfVisitors + "\nSelected menu\t\t|\t" + getSelectDishes + "\nTotal price\t\t\t|\t" + totalPrice + " (сом)\t\nService\t\t\t\t|\t" + servicePercentage + "%\n\t\t\t\u001B[91mcancel\u001B[0m\t\t\u001B[92msave\u001B[0m");
                                getInput = scanner.nextLine();
                                if("save".contains(getInput.trim().toLowerCase())) {
                                    events.markedDays.add(selectedTime);
                                    events.statusEvents.add("scheduled," + eventType(getEventType) + "," + getNumberOfVisitors + "," + totalPrice + "," + servicePercentage + ","+ getSelectDishes.trim());
                                    break;
                                } else if ("cancel".contains(getInput.trim().toLowerCase())) {
                                    break;
                                }
                            }
                        }
                    }
                    clearScreen();
                    events.displayDate();
                }
            } else if ("exit".contains(getInput.trim().toLowerCase())) {
                break;
            }
        }
    }

    public static void restaurantFunction (Restaurant restaurant) {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            clearScreen();
            restaurant.showRestaurants();
            String getInput = scanner.nextLine();
            if("add".contains(getInput.toLowerCase())) {
                clearScreen();
                prepareRestData(restaurant.restaurantsData);
            } else if ("exit".contains(getInput.toLowerCase())) {
                break;
            } else if(isContains(restaurant.restaurantsData, getInput.toUpperCase())) {
                int indexOfRest = getIndex(restaurant.restaurantsData, getInput.toUpperCase());
                while(true) {
                    clearScreen();
                    String restData = restaurant.restaurantsData.get(indexOfRest);
                    String[] splitRestData = restData.split(",\\s*");
                    System.out.println("\t\t\t\u001B[91m|\u001B[0m \u001B[97m" + splitRestData[0] + "\u001B[0m \u001B[91m|\u001B[0m\n<\u001B[91mexit\u001B[0m\t\t\t\t\t\u001B[92mchange\u001B[0m\nAddress\t\t\t|\t" + splitRestData[1] + "\nManager\t\t\t|\t" + splitRestData[2] + "\nHalls\t\t\t|\t" + splitRestData[3] + "\nStatus\t\t\t|\t" + splitRestData[4]);
                    getInput = scanner.nextLine();
                    if("exit".contains(getInput.toLowerCase())) {
                        break;
                    } else if ("change".contains(getInput.toLowerCase())) {
                        while(true) {
                            clearScreen();
                            System.out.println("<\u001B[91mexit\u001B[0m\n\t\t\u001B[91m|\u001B[0m \u001B[97mName\u001B[0m \u001B[91m|\u001B[0m  \u001B[91m|\u001B[0m \u001B[97mAddress\u001B[0m \u001B[91m|\u001B[0m  \u001B[91m|\u001B[0m \u001B[97mManager\u001B[0m \u001B[91m|\u001B[0m  \u001B[91m|\u001B[0m \u001B[97mHalls\u001B[0m \u001B[91m|\u001B[0m  \u001B[91m|\u001B[0m \u001B[97mStatus\u001B[0m \u001B[91m|\u001B[0m");
                            getInput = scanner.nextLine();
                            if("exit".contains(getInput.toLowerCase())) {
                                break;
                            } else {
                                clearScreen();
                                if("NAME".contains(getInput.toUpperCase())) {
                                    System.out.print("New name: ");
                                    changeRestData(restaurant.restaurantsData, restData, splitRestData, indexOfRest, 0);
                                } else if ("ADDRESS".contains(getInput.toUpperCase())) {
                                    System.out.print("New address: ");
                                    changeRestData(restaurant.restaurantsData, restData, splitRestData, indexOfRest, 1);
                                } else if ("MANAGER".contains(getInput.toUpperCase())) {
                                    System.out.print("New manager: ");
                                    changeRestData(restaurant.restaurantsData, restData, splitRestData, indexOfRest, 2);
                                } else if ("HALLS".contains(getInput.toUpperCase())) {
                                    System.out.print("New halls: ");
                                    changeRestData(restaurant.restaurantsData, restData, splitRestData, indexOfRest, 3);
                                } else if ("STATUS".contains(getInput.toUpperCase())) {
                                    while (true) {
                                        System.out.println("\t\t\t\u001B[94mSTATUS\u001B[0m\n\t\t•\u001B[92mON\u001B[0m\t\t•\u001B[91mOFF\u001B[0m");
                                        getInput = scanner.nextLine();
                                        if("ON".contains(getInput.toUpperCase())) {
                                            String replacedRestData = restData.replace(splitRestData[4], "ON");
                                            restaurant.restaurantsData.set(indexOfRest, replacedRestData);
                                            break;
                                        } else if ("OFF".contains(getInput.toUpperCase())) {
                                            String replacedRestData = restData.replace(splitRestData[4], "OFF");
                                            restaurant.restaurantsData.set(indexOfRest, replacedRestData);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void changeUsersData (ArrayList<String> managersData, String oldChar, String managerData, int index) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("  Name\n  \u001B[91m| \u001B[97m " + oldChar + " \u001B[91m|\u001B[0m");
        String newChar = scanner.nextLine();
        if (oldChar.matches(".*[A-ZА-Я].*")) {
            newChar = newChar.toUpperCase();
        }
        while(true) {
            clearScreen();
            System.out.println("\u001B[91m" + oldChar + "\u001B[0m --> \u001B[97m" + newChar + "\u001B[0m\n\t\t\u001B[97mcancel\u001B[0m\t\u001B[92msave\u001B[0m");
            String getInput = scanner.nextLine();
            if ("cancel".contains(getInput.trim().toLowerCase())) {
                break;
            } else if ("save".contains(getInput.trim().toLowerCase())) {
                String changedManagerData = managerData.replace(oldChar, newChar);
                managersData.set(index, changedManagerData);
                break;
            }
        }
    }

    public static boolean isCorrectData (String correctName, String correctPassword, int attempt) {
        Scanner scanner = new Scanner(System.in);
        if(attempt <= 3 && attempt != 0) {
            System.out.println("Left \u001B[91m" + attempt + "\u001B[0m attempts!");
        }
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.print("Enter password: ");
        String usersPassword = scanner.nextLine();
        if(correctName.equals(userName) && correctPassword.equals(usersPassword)) {
            clearScreen();
            return true;
        } else {
            clearScreen();
            if(attempt != 1) {
                System.out.println("\u001B[91mIncorrect username or password\u001B[0m!");
            }
            return false;
        }
    }

    public static void changeRestData(ArrayList<String> restaurantsData, String restData, String[] splitRestData, int indexOfRest, int indexCategory) {
        Scanner scanner = new Scanner(System.in);
        String getInput = scanner.nextLine();
        String replacedRestData;
        if(indexCategory == 0) {
            replacedRestData = restData.replace(splitRestData[indexCategory], getInput.toUpperCase());
        } else {
            replacedRestData = restData.replace(splitRestData[indexCategory], getInput);
        }
        while(true) {
            System.out.println(splitRestData[indexCategory] + " --> \u001B[97m" + getInput.toUpperCase() + "\u001B[0m\n\t\t\u001B[97mcancel\u001B[0m\t\u001B[92msave\u001B[0m");
            getInput = scanner.nextLine();
            if("save".contains(getInput.toLowerCase())) {
                restaurantsData.set(indexOfRest, replacedRestData);
                break;
            } else if ("cancel".contains(getInput.toLowerCase())) {
                break;
            }
        }
    }

    public static void prepareRestData(ArrayList<String> restaurantData) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String getRestName = scanner.nextLine();
        System.out.print("Address: ");
        String getRestAddress = scanner.nextLine();
        System.out.print("Name of Manager: ");
        String getNameOfManager = scanner.nextLine();
        System.out.print("Number of halls: ");
        String getNumberOfHalls = scanner.nextLine();
        String getRestStatus = "";
        while(true) {
            System.out.println("\t   Status\n\t•\u001B[92mON\u001B[0m\t\t•\u001B[91mOFF\u001B[0m");
            getRestStatus = scanner.nextLine();
            if("ON".contains(getRestStatus.toUpperCase())) {
                getRestStatus = "ON";
                break;
            } else if ("OFF".contains(getRestStatus.toUpperCase())) {
                getRestStatus = "OFF";
                break;
            }
        }
        while(true) {
            clearScreen();
            System.out.println("Name\t\t\t|\t" + getRestName.toUpperCase() + "\nAddress\t\t\t|\t" + getRestAddress + "\nManager\t\t\t|\t" + getNameOfManager.toUpperCase() + "\nHalls\t\t\t|\t" + getNumberOfHalls + "\nStatus\t\t\t|\t" + getRestStatus +
                    "\n\t\t\u001B[91mcancel\u001B[0m\t\u001B[92msave\u001B[0m");
            String getInput = scanner.nextLine();
            if("save".contains(getInput.toLowerCase())) {
                String newRestData = getRestName.toUpperCase() + ", " + getRestAddress + ", " + getNameOfManager.toUpperCase() + ", " + getNumberOfHalls + ", " + getRestStatus;
                restaurantData.add(newRestData);
                break;
            } else if ("cancel".contains(getInput.toLowerCase())) {
                break;
            }
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

    public static boolean isContains (ArrayList<String> list, String getInput) {
        for(String name : list) {
            if(name.contains(getInput)) {
                return true;
            }
        }
        return false;
    }

    public static int getIndex (ArrayList<String> list, String getInput) {
        String name;
        int i = 0;
        while (i < list.size()) {
            name = list.get(i);
            if(name.contains(getInput)) {
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
        int index = getIndex(listDishes, enteredDishes.toUpperCase());
        while(true) {
            clearScreen();
            String dishes = listDishes.get(index);
            String[] splitDishes = dishes.split("\\s+", 2);
            System.out.println("<\u001B[92mexit\u001B[0m\t\t\u001B[91mdelete\u001B[0m  \u001B[97mchange\u001B[0m\n\t" + splitDishes[1] + "\u001B[97m(\u001B[0m\u001B[91m" + splitDishes[0] + "\u001B[0m\u001B[97m)\u001B[0m");
            String getInput = scanner.nextLine();
            if ("exit".contains(getInput.trim().toLowerCase())) {
                break;
            } else if ("delete".contains(getInput.trim().toLowerCase())) {
                listDishes.remove(index);
                break;
            } else if ("change".contains(getInput.trim().toLowerCase())) {
                while(true) {
                    clearScreen();
                    System.out.print("<\u001B[92mexit\u001B[0m\n\tName: " + splitDishes[1] + "\t\tPrice: " + splitDishes[0] + "\nWhich one you want to change: ");
                    getInput = scanner.nextLine();
                    if("exit".contains(getInput.trim().toLowerCase())) {
                        break;
                    } else if ("name".contains(getInput.trim().toLowerCase())) {
                        clearScreen();
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        while(true) {
                            clearScreen();
                            System.out.println("\u001B[91m" + splitDishes[1] + "\u001B[0m --> \u001B[97m" + newName.toUpperCase() + "\u001B[0m\n\t\t\u001B[97mcancel\u001B[0m\t\u001B[92msave\u001B[0m");
                            getInput = scanner.nextLine();
                            if ("cancel".contains(getInput.trim().toLowerCase())) {
                                break;
                            } else if("save".contains(getInput.trim().toLowerCase())) {
                                String replacedDishes = dishes.replace(splitDishes[1], newName);
                                listDishes.set(index, replacedDishes.toUpperCase());
                                break;
                            }
                        }
                        if("save".contains(getInput.trim().toLowerCase())) {
                            break;
                        }
                    } else if ("price".contains(getInput.trim().toLowerCase())) {
                        clearScreen();
                        System.out.print("Enter new price: ");
                        String newPrice = scanner.nextLine();
                        while(true) {
                            clearScreen();
                            System.out.println("\u001B[91m" + splitDishes[0] + " -->\t\u001B[97m" + newPrice.toUpperCase() + "\u001B[0m\n\t\t\u001B[97mcancel\u001B[0m\t\u001B[92msave\u001B[0m");
                            getInput = scanner.nextLine();
                            if ("cancel".contains(getInput.trim().toLowerCase())) {
                                break;
                            } else if("save".contains(getInput.trim().toLowerCase())) {
                                String replacedDishes = dishes.replace(splitDishes[0], newPrice);
                                listDishes.set(index, replacedDishes.toUpperCase());
                                break;
                            }
                        }
                        if("save".contains(getInput.trim().toLowerCase())) {
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void addingMenuOperation (ArrayList<String> listDishes) {
        Scanner scanner = new Scanner(System.in);
        clearScreen();
        System.out.print("Name of new dishes: ");
        String dishesName = scanner.nextLine();
        clearScreen();
        System.out.print("Price of the new dishes: ");
        String dishesPrice = scanner.nextLine();

        while (true) {
            clearScreen();
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