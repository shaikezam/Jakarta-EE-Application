package io.shaikezam.persistence.repository;

import io.shaikezam.persistence.dao.AbstractDao;
import io.shaikezam.persistence.entity.OrderEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class OrderEntityDao extends AbstractDao<OrderEntity> {

    @Inject
    public OrderEntityDao() {
        super(OrderEntity.TABLE_NAME, OrderEntity.class);
    }
}
