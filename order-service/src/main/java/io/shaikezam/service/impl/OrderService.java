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
    public String test() {
        List<OrderEntity> persons = orderEntityDao.findAll();
        logger.info("Size: " + persons.size());

        for (OrderEntity currentPerson : persons) {
            //logger.info("Person: " + currentPerson);
        }
        return "COOL";
    }

    @Override
    public void test1() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserId(1L);
        orderEntity.setPrice(300.0);
        orderEntityDao.create(orderEntity);
    }
}
