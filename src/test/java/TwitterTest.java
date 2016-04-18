import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

public class TwitterTest {
//    private Twitter twitter = new Twitter();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();


    @Test
    public void printOptions()  {
        System.setOut(new PrintStream(outContent));
        String menu =   "\n\n1. Create User\n" +
                        "2. Post\n" +
                        "3. Follow\n" +
                        "4. Wall\n" +
                        "5. Change User\n" +
                        "6. Show Timeline\n" +
                        "7. Exit \n\n" +
                        "Please select your option : ";
        Twitter.printOptions();
        assertEquals(menu, outContent.toString());
    }

    @Ignore
    @Test
    public void selectOptions() {
        System.setOut(new PrintStream(outContent));
        String outPut = "Enter your new username: ";
        final Twitter Twitter = Mockito.spy(new Twitter());
        Mockito.when(Twitter.scanner()).thenReturn("1");
        Twitter.showMenu();
        assertEquals(outPut, outContent.toString());
    }
}