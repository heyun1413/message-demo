package pub.ron.messagedemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AlertServiceImpl implements AlertService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlertServiceImpl.class);

    private final JmsOperations jmsOperations;

    @Autowired
    public AlertServiceImpl(JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }

    @Override
    public void sendAlert(Alert alert) {
        jmsOperations.convertAndSend("test-queue", alert);
        Alert receiveAndConvert = (Alert) jmsOperations.receiveAndConvert("test-queue");
        LOGGER.info(Objects.toString(receiveAndConvert));
    }

}
