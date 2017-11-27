package greetservice;

import org.junit.Test;
import static org.junit.Assert.*;

public class GreetingControllerTest {

    @Test
    public void greeting() throws Exception {
        GreetingController gc = new GreetingController();
        assertEquals(gc.greeting("Sam").getContent(),"Hello, Sam!");
        assertEquals(gc.greeting("").getContent(),"Hello, !");
    }
}