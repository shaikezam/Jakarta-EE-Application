package io.shaikezam.persistence.repository;

import io.shaikezam.persistence.dao.AbstractDao;
import io.shaikezam.persistence.entity.ProductEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityTransaction;
import org.eclipse.persistence.config.QueryHints;

import java.util.List;

@ApplicationScoped
public class ProductEntityDao extends AbstractDao<ProductEntity> {

    @Inject
    public ProductEntityDao() {
        super(ProductEntity.TABLE_NAME, ProductEntity.class);
    }

    public List findProductNameById(Object id) {
        return entityManager.createQuery("SELECT p.name FROM " + ProductEntity.TABLE_NAME + " p WHERE p.id = :id")
                .setParameter("id", id)
                .getResultList();
    }

    public void decreaseProductQuantity(long productId, int quantityToDecrease) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            String query = String.format("""
                    UPDATE %s p
                    SET p.quantityAvailable = p.quantityAvailable - :quantityToDecrease, 
                        p.dateUpdated = CURRENT_TIMESTAMP, 
                        p.isAvailable = CASE WHEN p.quantityAvailable - :quantityToDecrease <= 0 THEN false ELSE p.isAvailable END 
                    WHERE p.id = :productId
                    """, ProductEntity.TABLE_NAME);

            int rowsUpdated = entityManager.createQuery(query)
                    .setParameter("quantityToDecrease", quantityToDecrease)
                    .setParameter("productId", productId)
                    .executeUpdate();
            transaction.commit();
            if (rowsUpdated > 0) {
                entityManager.refresh(this.findById(productId));
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
