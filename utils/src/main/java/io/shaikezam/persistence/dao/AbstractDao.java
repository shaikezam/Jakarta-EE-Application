package io.shaikezam.persistence.dao;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import lombok.NoArgsConstructor;

import java.util.List;

@ApplicationScoped
@NoArgsConstructor
public abstract class AbstractDao<T> {

    protected EntityManager entityManager;
    private String tableName;
    private Class<T> clazz;

    public AbstractDao(String tableName, Class<T> clazz) {
        this.tableName = tableName;
        this.clazz = clazz;
    }

    @Inject
    public void setEntityManager(@Named("normalScopedEntityManager") EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public T create(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(entity);
            transaction.commit();
            entityManager.refresh(entity);
            return entity;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public T update(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            T mergedEntity = entityManager.merge(entity);
            transaction.commit();
            entityManager.refresh(entity);
            return mergedEntity;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void delete(T entity) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public T findById(Object id) {
        return entityManager.find(clazz, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("SELECT e FROM " + tableName + " e", clazz)
                .getResultList();
    }


}
