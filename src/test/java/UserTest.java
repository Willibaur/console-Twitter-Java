import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;


public class UserTest {
    private User user = new User("Spike");
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void printPeeps() {
        System.setOut(new PrintStream(outContent));
        user.post("First message");
        user.printPeeps();
        String outPut = "These are the messages created so far:\n" +
                        "First message\n";
        assertEquals(outPut, outContent.toString());
    }

    @Test
    public void getName()  {
        assertEquals("Returns username", "Spike", user.getName());
    }

    @Test
    public void post()  {
        user.post("First message");
        ArrayList<String> peeps = new ArrayList<>();
        peeps.add("First message");
        assertEquals(1, user.peeps.size());
        assertEquals(peeps, user.peeps);
    }

    @Test
    public void follow()  {
        user.follow("Spike");
        ArrayList<String> following = new ArrayList<>();
        following.add("Spike");
        assertEquals(1, user.following.size());
        assertEquals(following, user.following);
    }
}

