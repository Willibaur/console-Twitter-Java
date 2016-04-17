import java.util.ArrayList;

/**
 * Created by william on 16/04/16.
 */
public class User {
    String username;
    ArrayList<String> peeps = new ArrayList<>();

    public void post(String message) {
        peeps.add(message);
    }

    public  void setName(String name) {
        username = name;
    }

    public String getName() {
        return username;
    }
}
