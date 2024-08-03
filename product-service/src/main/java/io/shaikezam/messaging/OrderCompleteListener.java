package io.shaikezam.messaging;

import io.shaikezam.model.OrderProductsDTO;
import io.shaikezam.service.IProductService;
import io.shaikezam.web.listener.messaging.JMSListenerServletContextListener;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
public class OrderCompleteListener extends JMSListenerServletContextListener<HashSet> {

    private static final Logger logger = Logger.getLogger(OrderCompleteListener.class.getName());
    private final IProductService productService;

    @Inject
    public OrderCompleteListener(IProductService productService) {

        super(QueueConstants.BROKER_URL, QueueConstants.ORDER_COMPLETED_QUEUE_NAME, HashSet.class);
        this.productService = productService;
    }

    public void initialize(@Observes @Initialized(ApplicationScoped.class) Object init) {
        // Force an application-scoped bean to instantiate at application startup
        //The trick is to let the bean observe the initialization of the built-in lifecycle scopes, i.e. ApplicationScoped in this case.
        // https://stackoverflow.com/a/32520226/5769672
    }

    @Override
    public void handleMessage(HashSet data) {
        try {
            ((HashSet<OrderProductsDTO>) data)
                    .forEach(orderProductsDTO ->
                            this.productService.updateProductQuantity(orderProductsDTO.getProductId(), orderProductsDTO.getQuantity()));
        } catch (Exception e) {
            // Print the stack trace
            logger.log(Level.SEVERE, "An exception occurred", e);
        }
    }
}
