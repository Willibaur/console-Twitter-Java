import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Twitter {

    public static HashMap users = new HashMap();
    private static String currentUser;

    public static void main(String args[]) {
        out.println("Java Network");
        menu();
    }

    private static void menu() {

        out.println("Menu");
        out.println("1. Create User");
        out.println("2. Post a message");
        out.println("3. Change User");
        out.println("4. Wall");
        out.println("5. Follow");
        out.println("6. Exit");
        out.println("Please enter your option: ");

        switch (scanner()) {
            case "1":
                createUser();
                break;
            case "2":
                postMessage();
                break;
            default:
                out.println("Invalid option");
                break;
        }
    }

    private static void postMessage() {
        out.println("Welcome" + currentUser);
        out.println("Message:");

    }

    private static void createUser() {
        out.println("User Menu");
        out.println("Enter your new username:");

        String user = scanner();
        currentUser = user;

        if (validateUser(user)) {
            out.println("Username already exists!");
            createUser();
        }

        users.put(user, createUserHashMap());
        out.println(users);
        menu();
    }

    private static HashMap createUserHashMap() {
        HashMap userHashMap = new HashMap();
        userHashMap.put("Peeps", new ArrayList<String>());
        userHashMap.put("Following", new ArrayList<String>());
        return userHashMap;
    }

    private static boolean validateUser(String user) {
        return users.containsKey(user);
    }

    private static String scanner() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}