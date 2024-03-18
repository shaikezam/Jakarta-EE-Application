package io.shaikezam;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Qualifier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;

@Named
@ApplicationScoped
public class UtilResource {


//    public void closeEntityManager(@Disposes EntityManager em) {
//        if (em != null && em.getTransaction().isActive()) {
//            em.getTransaction().rollback();
//        }
//        if (em != null && em.isOpen()) {
//            em.close();
//        }
//    }
}
