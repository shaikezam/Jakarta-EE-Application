package io.shaikezam.persistence.repository;

import io.shaikezam.persistence.dao.AbstractDao;
import io.shaikezam.persistence.entity.ProductEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ProductEntityDao extends AbstractDao<ProductEntity> {

    @Inject
    public ProductEntityDao() {
        super(ProductEntity.TABLE_NAME, ProductEntity.class);
    }

    public List<String> findProductNameById(Object id) {
        return entityManager.createQuery("SELECT p.name FROM " + ProductEntity.TABLE_NAME + " p WHERE p.id = :id")
                .setParameter("id", id)
                .getResultList();
    }
}
