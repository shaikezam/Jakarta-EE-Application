package io.shaikezam.messaging;

import jakarta.enterprise.context.RequestScoped;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import org.apache.activemq.ActiveMQConnectionFactory;

import java.io.Serializable;

@RequestScoped
public class MessageProducer {

    private String activeMqUser = System.getenv("ACTIVE_MQ_USER");
    private String activeMqPassword = System.getenv("ACTIVE_MQ_PASSWORD");

    public void sendMessage(String brokerUrl, String destination, Serializable message) {
        ConnectionFactory connectionFactory = new org.apache.activemq.ActiveMQConnectionFactory(brokerUrl);
        ((ActiveMQConnectionFactory) connectionFactory).setTrustAllPackages(true);
        try (JMSContext context = connectionFactory.createContext(this.activeMqUser, this.activeMqPassword, JMSContext.AUTO_ACKNOWLEDGE)) {
            context.createProducer().send(context.createQueue(destination), message);
        }
    }
}
