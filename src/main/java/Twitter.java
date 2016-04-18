import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.out;

public class Twitter {

    public static HashMap users = new HashMap();
    public static User user;
    public static String currentUser = "";

    public static void main(String args[]) {
        out.printf("Java Network Menu");
        showMenu();
    }

    public static void showMenu() {
        printOptions();
        selectOption();
    }

    public  static void printOptions() {
        out.printf("%n%n1. Create User%n");
        out.println("2. Post");
        out.println("3. Follow");
        out.println("4. Wall");
        out.println("5. Change User");
        out.println("6. Show Timeline");
        out.printf("7. Exit %n%n");
        out.printf("Please select your option %s: ", currentUser);
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
        showMenu();
    }

    public  static void changeUser() {
        if (users.size() >= 2) {
            out.printf("%nSelect user: ");
            showAllUsers();
            currentUser = scanner();
            user = (User) users.get(currentUser);
        } else {
            out.printf("%n%nThere are no more users %s!!!", currentUser);
        }
        showMenu();
    }

    public  static void followUser() {
        if (users.size() <= 1) {
            out.printf("%n%nThere are no users to follow!!!");
            showMenu();
        }
        showAllUsers();
        out.printf("%n%nSelect an user to follow %s: ", currentUser);
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
        out.printf("%n%nEnter your message %s: ", currentUser);
        user.post(scanner());
        showMenu();
    }

    public  static void createUser() {
        out.print("Enter your new username: ");

        currentUser = scanner();
        user = new User(currentUser);
        users.put(currentUser, user);
        out.printf("%n%nYour username is %s", currentUser);
        showMenu();
    }

    public  static void showAllUsers() {
        out.printf("%n%nThis is the list of users created so far %s: ", currentUser);
        out.println(users.keySet());
    }


    public  static void exitProgram() {
        out.printf("%n%nThank you for using our service %s, have a good day!", currentUser);
    }

    public  static String scanner() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
