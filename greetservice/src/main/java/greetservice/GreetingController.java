package greetservice;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private Log log = LogFactory.getLog(GreetingController.class);

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        Greeting greeting = new Greeting(counter.incrementAndGet(),
                String.format(template, name));
        log.info("Greeting sent with id:"+greeting.getId());
        return greeting;
    }
}
