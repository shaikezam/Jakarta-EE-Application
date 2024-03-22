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

        TypedQuery<Person> query = entityManager.createQuery("SELECT p FROM PERSON p", Person.class);
        List<Person> persons = query.getResultList();
        logger.info("Size: " + persons.size());
        entityManager.getTransaction().commit();

        for (Person currentPerson : persons) {
            //logger.info("Person: " + currentPerson);
        }
        return "COOL";
    }


    @Override
    public void test1() {
        entityManager.getTransaction().begin();
        Person person = new Person();
        person.setName("Shai");
        entityManager.persist(person);
        entityManager.getTransaction().commit();
    }
}
