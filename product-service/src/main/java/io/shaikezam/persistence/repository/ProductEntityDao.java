package io.shaikezam.persistence.repository;

import io.shaikezam.persistence.dao.AbstractDao;
import io.shaikezam.persistence.entity.ProductEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ProductEntityDao extends AbstractDao<ProductEntity> {

    @Inject
    public ProductEntityDao() {
        super(ProductEntity.TABLE_NAME, ProductEntity.class);
    }
}
