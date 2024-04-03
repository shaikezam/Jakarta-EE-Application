package io.shaikezam.web.listener.messaging;

import io.shaikezam.model.DummyDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.jms.*;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import lombok.RequiredArgsConstructor;
import org.apache.activemq.ActiveMQConnectionFactory;

@RequiredArgsConstructor
@ApplicationScoped
public class JMSListenerServletContextListener implements ServletContextListener, MessageListener {

    private String activeMqUser = System.getenv("ACTIVE_MQ_USER");
    private String activeMqPassword = System.getenv("ACTIVE_MQ_PASSWORD");
    private final String brokerUrl;
    private final String destination;

    @Override
    public void onMessage(Message message) {
        try {
            DummyDTO messageDTO = message.getBody(DummyDTO.class);
            System.out.println(messageDTO);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
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
        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
