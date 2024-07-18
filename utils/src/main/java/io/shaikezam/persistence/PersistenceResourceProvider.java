package io.shaikezam.persistence;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Default;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.logging.Logger;

@ApplicationScoped
public class PersistenceResourceProvider {

    private static final Logger logger = Logger.getLogger(PersistenceResourceProvider.class.getName());

    @Produces
    @Default
    @ApplicationScoped
    public EntityManagerFactory createEntityManagerFactory() {
        logger.info("create EntityManagerFactory...");
        String persistenceUnitName = "default"; // Set your persistence unit name here
        String dbHost = System.getenv("DB_HOST");
        String dbPort = System.getenv("DB_PORT");
        String dbName = System.getenv("DB_NAME");
        String dbUrl = String.format("jdbc:mariadb://%s:%s/%s", dbHost, dbPort, dbName);
        String jdbcUser = System.getenv("DB_USER");
        String jdbcPassword = System.getenv("DB_PASS");

        // Set the database properties
        java.util.Properties properties = new java.util.Properties();
        properties.setProperty("jakarta.persistence.jdbc.url", dbUrl);
        properties.setProperty("jakarta.persistence.jdbc.user", jdbcUser);
        properties.setProperty("jakarta.persistence.jdbc.password", jdbcPassword);

        // Create the EntityManagerFactory
        return Persistence.createEntityManagerFactory(persistenceUnitName, properties);
    }

    @Produces
    @Named("requestScopedEntityManager")
    @RequestScoped
    public EntityManager createRequestScopedEntityManager(EntityManagerFactory entityManagerFactory) {
        logger.info("create Request Scoped EntityManager...");
        return entityManagerFactory.createEntityManager();
    }

    @Produces
    @Named("normalScopedEntityManager")
    @Dependent
    public EntityManager createNormalScopedEntityManager(EntityManagerFactory entityManagerFactory) {
        logger.info("create Normal Scoped EntityManager...");
        return entityManagerFactory.createEntityManager();
    }

    public void disposeRequestScopedEntityManager(@Disposes @Named("requestScopedEntityManager") EntityManager entityManager) {
        logger.info("dispose Request Scoped EntityManager...");
        closeEntityManager(entityManager);
    }

    public void disposeNormalScopedEntityManager(@Disposes @Named("normalScopedEntityManager") EntityManager entityManager) {
        logger.info("dispose Normal Scoped EntityManager...");
        closeEntityManager(entityManager);
    }

    private void closeEntityManager(EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}

