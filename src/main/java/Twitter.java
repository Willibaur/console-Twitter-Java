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
        out.println("1. Create User");
        out.println("2. Post a message");
        out.println("3. Follow");
        out.println("4. Wall");
        out.println("5. Change User");
        out.printf("6. Exit %n%n");
        out.print("Please enter your option: ");

        switch (scanner()) {
            case "1":
                createUser();
                break;
            case "2":
                postMessage();
                break;
            case "3":
                follow();
                break;
            case "4":
                break;
            case "5":
                changeUser();
                break;
            default:
                out.println("Invalid option");
                break;
        }
    }

    private static void changeUser() {
        if (users.size() >= 2) {
            out.printf("%nSelect user: ");
            out.println(users.keySet());
            currentUser = scanner();
            user = (User) users.get(currentUser);
        } else {
            out.println("There are no more users!!!");
        }
        menu();
    }

    private static void follow() {
        if (users.size() <= 1) {
            out.println("There are no users to follow!!!");
        }
        out.println("Select an user to follow");
    }

    private static void postMessage() {
        out.print(currentUser + ": ");
        user.post(scanner());
        out.println(user.peeps);
        menu();
    }

    private static void createUser() {
        out.print("Enter your new username: ");

        currentUser = scanner();
        user = new User();
        user.setName(currentUser);
        out.printf("Your username is %s%n%n", user.getName());
        users.put(currentUser, user);
        menu();
    }

    private static String scanner() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}