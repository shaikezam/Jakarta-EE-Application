package io.shaikezam.messaging;

public class QueueConstants {
    public static final String BROKER_URL = "tcp://messaging-service:61616";
    public static final String ORDER_COMPLETED_QUEUE_NAME = "ORDER.COMPLETED";

    private QueueConstants() {
        throw new IllegalStateException(QueueConstants.class.getName() + " can't be object!!!");
    }
}
