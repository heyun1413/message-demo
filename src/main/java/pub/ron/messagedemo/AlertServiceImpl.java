package pub.ron.messagedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;

@Service
public class AlertServiceImpl implements AlertService {



    private final JmsOperations jmsOperations;

    @Autowired
    public AlertServiceImpl(JmsOperations jmsOperations) {
        this.jmsOperations = jmsOperations;
    }

    @Override
    public void sendAlert(Alert alert) {
        jmsOperations.convertAndSend("test-queue", alert);
    }

}
