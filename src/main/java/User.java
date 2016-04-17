import java.util.ArrayList;

import static java.lang.System.out;

/**
 * Created by william on 16/04/16.
 */
public class User {
    String username;
    ArrayList<String> peeps = new ArrayList<>();

    public User(String name) {
        username = name;
    }

    public void post(String message) {
        peeps.add(message);
    }

    public String getName() {
        return username;
    }

    public void printPeeps() {
        out.println("These are the messages created so far:");
        for (String object: peeps) out.println(object);

//        out.println("This is the ArrayList with the messages:");
//        out.printf("%s%n%n", peeps);
    }
}


