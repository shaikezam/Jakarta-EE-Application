package io.shaikezam.service.impl;

import io.shaikezam.mapper.IOrderMapper;
import io.shaikezam.messaging.MessageProducer;
import io.shaikezam.messaging.QueueConstants;
import io.shaikezam.model.OrderDTO;
import io.shaikezam.model.OrderProductsDTO;
import io.shaikezam.persistence.entity.OrderEntity;
import io.shaikezam.persistence.repository.OrderEntityDao;
import io.shaikezam.service.IOrderService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor = @__({@Inject}))
public class OrderService implements IOrderService {

    private final OrderEntityDao orderEntityDao;
    private final IOrderMapper orderMapper;
    private final MessageProducer messageProducer;

    private static final Logger logger = Logger.getLogger(OrderService.class.getName());

    @Override
    public List<OrderDTO> getAllOrders() {
        List<OrderEntity> orderEntities = orderEntityDao.findAll();
        return orderMapper.orderEntitiesToDTOS(orderEntities);
    }

    @Override
    public Optional<OrderDTO> getOrder(long orderId) {
        OrderEntity orderEntity = orderEntityDao.findById(orderId);
        return orderEntity == null ? Optional.empty() : Optional.of(orderMapper.orderEntityToOrderDTO(orderEntity));
    }

    @Override
    public void updateOrder(long orderId, OrderDTO orderDTO) {
        OrderEntity orderEntity = orderEntityDao.findById(orderId);
        orderEntity.setPrice(orderDTO.getPrice());
        orderEntityDao.update(orderEntity);
    }

    @Override
    public void createNewOrder(OrderDTO orderDto) {
        orderEntityDao.create(orderMapper.orderDTOToOrderEntity(orderDto));
        HashSet<OrderProductsDTO> orderProductsDTOS = new HashSet<>(orderDto.getOrderProducts());
        logger.info("Will send an order event " + orderProductsDTOS);
        messageProducer.sendMessage(QueueConstants.BROKER_URL, QueueConstants.ORDER_COMPLETED_QUEUE_NAME, orderProductsDTOS);
    }

    @Override
    public void deleteOrder(long orderId) {
        Optional<OrderDTO> optionalOrder = getOrder(orderId);
        if (optionalOrder.isEmpty()) {
            return;
        }
        orderEntityDao.delete(orderEntityDao.findById(orderId));
    }
}
