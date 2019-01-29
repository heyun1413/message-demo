package pub.ron.messagedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AlertHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlertHandler.class);

    @JmsListener(destination = "test-queue")
    public void handleAlert(Alert alert) {
        LOGGER.info(alert.getTitle());
    }
}
