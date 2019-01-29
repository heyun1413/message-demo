package pub.ron.messagedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("alertServiceMail")
public class AlertServiceMailImpl implements AlertService {


    private final JavaMailSender javaMailSender;

    private final JmsOperations jmsOperations;

    @Autowired
    public AlertServiceMailImpl(JavaMailSender javaMailSender,
                                JmsOperations jmsOperations) {
        this.javaMailSender = javaMailSender;
        this.jmsOperations = jmsOperations;
    }

    @Override
    public void sendAlert(Alert alert) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("abc@qq.com");
        message.setTo("1358612584@qq.com");
        message.setSubject("hello, how are you?");
        message.setText("today is beautiful!");
        javaMailSender.send(message);
    }

}
