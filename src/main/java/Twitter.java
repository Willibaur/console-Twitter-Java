import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;

public class Twitter {
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
        out.println("\n Please enter your option: ");

        switch (parseInt(scanner())) {
            case 1:
                createUser();
                break;
            default:
                out.println("Invalid option");
                break;
        }
    }

    private static String scanner() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private static void createUser() {
        List<String> users = new ArrayList<String>();

        out.println("User Menu");
        out.print("Enter your username: ");
        users.add(scanner());
    }

}