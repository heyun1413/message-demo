package pub.ron.messagedemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MessageDemoApplicationTests {

    @Autowired
    @Qualifier("alertServiceMail")
    private AlertService alertService;

    @Test
    public void contextLoads() {
        alertService.sendAlert(new Alert("hello world"));
    }

}

