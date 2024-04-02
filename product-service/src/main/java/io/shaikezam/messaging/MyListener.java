package io.shaikezam.messaging;

import jakarta.jms.*;

public class MyListener implements MessageListener {
    private static final String BROKER_URL = "tcp://messaging:61616";
    private static final String QUEUE_NAME = "TEST.FOO";

    public void listen() {
        new Thread(() -> {
            ConnectionFactory connectionFactory = new org.apache.activemq.ActiveMQConnectionFactory(BROKER_URL);
            try (JMSContext context = connectionFactory.createContext("admin", "admin", JMSContext.AUTO_ACKNOWLEDGE)) {
                JMSConsumer consumer = context.createConsumer(context.createQueue(QUEUE_NAME));
                consumer.setMessageListener(this);
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println(((TextMessage) message).getText());
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
