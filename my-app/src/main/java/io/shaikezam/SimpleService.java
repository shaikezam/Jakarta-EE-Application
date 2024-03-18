package io.shaikezam;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Qualifier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.List;

@ApplicationScoped
public class SimpleService implements ISimpleService {

    @Override
    public String test() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        TypedQuery<Person> query = entityManager.createQuery("SELECT u FROM Person u", Person.class);
        List<Person> persons = query.getResultList();

        entityManager.getTransaction().commit();

        for (Person currentPerson : persons) {
            System.out.println("User: " + currentPerson);
        }
        return "COOL";
    }
}
