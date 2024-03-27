package io.shaikezam.service;

import io.shaikezam.model.OrderDTO;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<OrderDTO> getAllOrders();

    Optional<OrderDTO> getOrder(long orderId);

    void updateOrder(long orderId, OrderDTO orderDTO);

    void createNewOrder(OrderDTO orderDto);

    void deleteOrder(long orderId);
}
