package io.shaikezam;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class SimpleService implements ISimpleService {

    @Inject
    private EntityManager entityManager;

    private static final Logger logger = Logger.getLogger(SimpleService.class.getName());

    @Override
    public String test() {
        entityManager.getTransaction().begin();

        TypedQuery<OrderEntity> query = entityManager.createQuery("SELECT p FROM ORDERS p", OrderEntity.class);
        List<OrderEntity> persons = query.getResultList();
        logger.info("Size: " + persons.size());
        entityManager.getTransaction().commit();

        for (OrderEntity currentPerson : persons) {
            //logger.info("Person: " + currentPerson);
        }
        return "COOL";
    }

    @Override
    public void test1() {
        entityManager.getTransaction().begin();
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserId(1L);
        orderEntity.setPrice(300.0);
        entityManager.persist(orderEntity);
        entityManager.getTransaction().commit();
    }
}
