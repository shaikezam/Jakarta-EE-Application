package io.shaikezam.service;

import io.shaikezam.model.OrderDTO;

import java.util.List;

public interface IOrderService {
    List<OrderDTO> getAllOrders();
}
