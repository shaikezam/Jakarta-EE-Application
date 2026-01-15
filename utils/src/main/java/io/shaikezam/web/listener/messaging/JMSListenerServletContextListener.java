package io.shaikezam.web.listener.messaging;

import jakarta.annotation.PostConstruct;
import jakarta.jms.*;
import jakarta.servlet.ServletContextListener;
import lombok.RequiredArgsConstructor;
import org.apache.activemq.ActiveMQConnectionFactory;

@RequiredArgsConstructor
public abstract class JMSListenerServletContextListener<T> implements ServletContextListener, MessageListener {

    private String activeMqUser = System.getenv("ACTIVE_MQ_USER");
    private String activeMqPassword = System.getenv("ACTIVE_MQ_PASSWORD");
    private final String brokerUrl;
    private final String destination;
    private final Class<T> clazz;

    @Override
    public void onMessage(Message message) {
        try {
            T t = message.getBody(clazz);
            this.handleMessage(t);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    public void init() {
        // Initialization logic goes here
        this.registerMessageConsumer();
    }

    public void registerMessageConsumer() {
        new Thread(() -> {
            ConnectionFactory connectionFactory = new org.apache.activemq.ActiveMQConnectionFactory(this.brokerUrl);
            ((ActiveMQConnectionFactory) connectionFactory).setTrustAllPackages(true);
            try (JMSContext context = connectionFactory.createContext(this.activeMqUser, this.activeMqPassword, JMSContext.AUTO_ACKNOWLEDGE)) {
                JMSConsumer consumer = context.createConsumer(context.createQueue(this.destination));
                consumer.setMessageListener(this);
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public abstract void handleMessage(T t);

}
