package io.shaikezam.messaging;

import jakarta.enterprise.context.RequestScoped;
import jakarta.jms.*;

@RequestScoped
public class MessageProducer {

    public void sendMessage(String brokerUrl, String destination, String message) {
        ConnectionFactory connectionFactory = new org.apache.activemq.ActiveMQConnectionFactory(brokerUrl);
        try (JMSContext context = connectionFactory.createContext("admin", "admin", JMSContext.AUTO_ACKNOWLEDGE)) {
            context.createProducer().send(context.createQueue(destination), context.createTextMessage(message));
        }
    }
}
