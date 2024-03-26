package io.shaikezam.service.impl;

import io.shaikezam.persistence.entity.OrderEntity;
import io.shaikezam.persistence.repository.OrderEntityDao;
import io.shaikezam.service.IOrderService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class OrderService implements IOrderService {

    @Inject
    private OrderEntityDao orderEntityDao;

    private static final Logger logger = Logger.getLogger(OrderService.class.getName());

    @Override
    public List<OrderEntity> getAllOrders() {
        return orderEntityDao.findAll();
    }
}
