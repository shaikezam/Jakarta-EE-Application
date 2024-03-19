package io.shaikezam;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class SimpleService implements ISimpleService {

    private static final Logger logger = Logger.getLogger(SimpleService.class.getName());

    @Override
    public String test() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM PERSON p", Person.class);
        List<Person> persons = query.getResultList();
        logger.info("Size: " + persons.size());
        entityManager.getTransaction().commit();

        for (Person currentPerson : persons) {
            logger.info("Person: " + currentPerson);
            System.out.println("User: " + currentPerson);
        }
        return "COOL";
    }
}
