package io.shaikezam.service;

import io.shaikezam.persistence.entity.OrderEntity;

import java.util.List;

public interface IOrderService {
    List<OrderEntity> getAllOrders();
}
