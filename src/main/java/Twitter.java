import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.out;

public class Twitter {

    public static HashMap users = new HashMap();
    public static User user;
    public static String currentUser;

    public static void main(String args[]) {
        out.printf("Java Network Menu %n%n");
        showMenu();
    }

    public static void showMenu() {
        printOptions();
        selectOption();
    }

    public  static void printOptions() {
        out.println("1. Create User");
        out.println("2. Post a message");
        out.println("3. Follow");
        out.println("4. Show messages");
        out.println("5. Change User");
        out.println("6. Show followed timeline");
        out.printf("7. Exit %n%n");
        out.print("Please enter your option: ");
    }

    public  static void selectOption() {
        switch (scanner()) {
            case "1":
                createUser();
                break;
            case "2":
                postMessage();
                break;
            case "3":
                followUser();
                break;
            case "4":
                showMessages();
                break;
            case "5":
                changeUser();
                break;
            case "6":
                showFollowedTimelines();
                break;
            case "7":
                exitProgram();
                break;
            default:
                out.println("Invalid option, try again.");
                showMenu();
                break;
        }
    }

    public static void showFollowedTimelines() {
        for (String object: user.following) {
            User temp = (User) users.get(object);
            temp.printPeeps();
        }
    }

    public  static void changeUser() {
        if (users.size() >= 2) {
            out.printf("%nSelect user: ");
            showAllUsers();
            currentUser = scanner();
            user = (User) users.get(currentUser);
        } else {
            out.println("There are no more users!!!");
        }
        showMenu();
    }

    public  static void followUser() {
        if (users.size() <= 1) {
            out.println("There are no users to follow!!!");
            showMenu();
        }
        showAllUsers();
        out.println("Select an user to follow: ");
        user.follow(scanner());
        showMenu();
    }

    public  static void showMessages() {
        user.printPeeps();
        showMenu();
    }

    public  static void postMessage() {
        if (users.size() == 0) {
            out.println("Please, create a user first.");
            showMenu();
        }
        user.post(scanner());
        showMenu();
    }

    public  static void createUser() {
        out.print("Enter your new username: ");

        currentUser = scanner();
        user = new User(currentUser);
        users.put(currentUser, user);
        showCurrentUser();
    }

    public  static void showAllUsers() {
        out.printf("%nThis is the list of users created so far:");
        out.println(users.keySet());
    }

    public  static void showCurrentUser() {
        out.printf("Username: %s%n%n", user.getName());
        showMenu();
    }

    public  static void exitProgram() {
        out.println("Thank you for using our service, have a good day!");
    }

    public  static String scanner() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
