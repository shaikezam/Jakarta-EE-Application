package io.shaikezam.messaging;

public class QueueConstants {
    public static String BROKER_URL = "tcp://messaging-service:61616";
    public static String ORDER_COMPLETED_QUEUE_NAME = "ORDER.COMPLETED";

    private QueueConstants() {
        throw new IllegalStateException(QueueConstants.class.getName() + " can't be object!!!");
    }
}
