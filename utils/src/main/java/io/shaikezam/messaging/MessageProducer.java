package io.shaikezam.messaging;

import jakarta.enterprise.context.RequestScoped;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;

@RequestScoped
public class MessageProducer {

    private String activeMqUser = System.getenv("ACTIVE_MQ_USER");
    private String activeMqPassword = System.getenv("ACTIVE_MQ_PASSWORD");

    public void sendMessage(String brokerUrl, String destination, String message) {
        ConnectionFactory connectionFactory = new org.apache.activemq.ActiveMQConnectionFactory(brokerUrl);
        try (JMSContext context = connectionFactory.createContext(this.activeMqUser, this.activeMqPassword, JMSContext.AUTO_ACKNOWLEDGE)) {
            context.createProducer().send(context.createQueue(destination), context.createTextMessage(message));
        }
    }
}
