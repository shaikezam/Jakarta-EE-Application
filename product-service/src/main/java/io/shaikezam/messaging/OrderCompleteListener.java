package io.shaikezam.messaging;

import io.shaikezam.model.OrderProductsDTO;
import io.shaikezam.service.IProductService;
import io.shaikezam.web.listener.messaging.JMSListenerServletContextListener;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;

import java.util.HashSet;

@ApplicationScoped
public class OrderCompleteListener extends JMSListenerServletContextListener<HashSet> {

    private final IProductService productService;

    @Inject
    public OrderCompleteListener(IProductService productService) {
        super(QueueConstants.BROKER_URL, QueueConstants.ORDER_COMPLETED_QUEUE_NAME, HashSet.class);
        this.productService = productService;
    }

    public void initialize(@Observes @Initialized(ApplicationScoped.class) Object init) {
        // This method will be called when the application scope is initialized
    }

    @Override
    public void handleMessage(HashSet data) {
        try {
            ((HashSet<OrderProductsDTO>) data)
                    .forEach(orderProductsDTO ->
                            this.productService.updateProductQuantity(orderProductsDTO.getProductId(), orderProductsDTO.getQuantity()));
        } catch (Exception e) {
            // Print the stack trace
            System.out.println("Exception occurred:");
            e.printStackTrace(System.out);
        }
    }
}
