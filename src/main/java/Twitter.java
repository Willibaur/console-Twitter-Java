import java.util.*;

import static java.lang.System.out;

public class Twitter {

    private static HashMap users = new HashMap();
    private static User user;
    private static String currentUser;

    public static void main(String args[]) {
        out.printf("Java Network Menu %n%n");
        menu();
    }

    private static void menu() {
        printOptions();
        selectOption();
    }


    private static void printOptions() {
        out.println("1. Create User");
        out.println("2. Post a message");
        out.println("3. Follow");
        out.println("4. Show messages");
        out.println("5. Change User");
        out.printf("6. Exit %n%n");
        out.print("Please enter your option: ");
    }

    private static void selectOption() {
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
                exitProgram();
                break;
            default:
                out.println("Invalid option, try again.");
                menu();
                break;
        }
    }

    private static void changeUser() {
        if (users.size() >= 2) {
            out.printf("%nSelect user: ");
            showAllUsers();
            currentUser = scanner();
            user = (User) users.get(currentUser);
        } else {
            out.println("There are no more users!!!");
        }
        menu();
    }

    private static void followUser() {
        if (users.size() <= 1) {
            out.println("There are no users to follow!!!");
        }
        out.println("Select an user to follow");
    }

    private static void showMessages() {
        user.printPeeps();
        menu();
    }

    private static void postMessage() {
        if (users.size() == 0) {
            out.println("Please, create a user first.");
            menu();
        }
        user.post(scanner());
        menu();
    }

    private static void createUser() {
        out.print("Enter your new username: ");

        currentUser = scanner();
        user = new User(currentUser);
        users.put(currentUser, user);
        showCurrentUser();
    }

    private static void showAllUsers() {
        out.printf("%nThis is the list of users created so far:");
        out.println(users.keySet());
    }

    private static void showCurrentUser() {
        out.printf("Username: %s%n%n", user.getName());
        menu();
    }

    private static void exitProgram() {
        out.println("Thank you for using our service, have a good day!");
    }

    private static String scanner() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
