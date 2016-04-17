import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;


public class UserTest {
    private User user = new User("Spike");

    @Test
    public void printPeeps() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));
        user.post("First message");
        user.printPeeps();
        assertEquals("These are the messages created so far:\nFirst message\n", outContent.toString());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("Returns username", "Spike", user.getName());
    }

    @Test
    public void post() throws Exception {
        user.post("First message");
        ArrayList<String> peeps = new ArrayList<>();
        peeps.add("First message");
        assertEquals(1, user.peeps.size());
        assertEquals(peeps, user.peeps);
    }
}

