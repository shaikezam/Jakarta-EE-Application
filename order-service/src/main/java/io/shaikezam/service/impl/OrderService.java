package io.shaikezam.service.impl;

import io.shaikezam.mapper.IOrderMapper;
import io.shaikezam.model.OrderDTO;
import io.shaikezam.persistence.entity.OrderEntity;
import io.shaikezam.persistence.repository.OrderEntityDao;
import io.shaikezam.service.IOrderService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor = @__({ @Inject }))
public class OrderService implements IOrderService {

    private final OrderEntityDao orderEntityDao;
    private final IOrderMapper orderMapper;

    private static final Logger logger = Logger.getLogger(OrderService.class.getName());

    @Override
    public List<OrderDTO> getAllOrders() {
        List<OrderEntity> orderEntities = orderEntityDao.findAll();
        return orderMapper.entitiesToDTOS(orderEntities);
    }
}
