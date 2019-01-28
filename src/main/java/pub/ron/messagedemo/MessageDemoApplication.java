package pub.ron.messagedemo;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQMessage;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import javax.jms.ConnectionFactory;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class MessageDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(MessageDemoApplication.class, args);

    }

    @Bean
    ActiveMQConnectionFactory activeMQConnectionFactory() {
        final ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
        activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");
        activeMQConnectionFactory.setTrustAllPackages(true);
        return activeMQConnectionFactory;
    }

    @Bean
    ActiveMQQueue activeMQQueue() {
        return new ActiveMQQueue("test-queue");
    }

    @Bean
    ActiveMQTopic activeMQTopic() {
        return new ActiveMQTopic("test-topic");
    }

    @Bean
    MappingJackson2MessageConverter mappingJackson2MessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        Map<String, Class<?>> typeIdMap = new HashMap<>();
        typeIdMap.put("Alert", Alert.class);
        converter.setTypeIdMappings(typeIdMap);
        // 设置发送到队列中的typeId的名称
        converter.setTypeIdPropertyName("Alert");

        return converter;
    }

    @Bean
    JmsTemplate jmsTemplate(ConnectionFactory connectionFactory,
                            MessageConverter messageConverter) {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        jmsTemplate.setMessageConverter(messageConverter);
        return jmsTemplate;
    }


}

