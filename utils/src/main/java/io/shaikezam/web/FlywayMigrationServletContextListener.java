package io.shaikezam.web;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.flywaydb.core.Flyway;

public class FlywayMigrationServletContextListener implements ServletContextListener {

    String dbHost = System.getenv("DB_HOST");
    String dbPort = System.getenv("DB_PORT");
    String dbUrl = String.format("jdbc:mariadb://%s:%s/%s", dbHost, dbPort, "order_service");
    Flyway flyway = Flyway.configure()
            .dataSource(dbUrl, System.getenv("DB_USER"), System.getenv("DB_PASS"))
            .locations("db/migration")
            .load();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Flyway flyway = Flyway.configure()
                .dataSource(dbUrl, System.getenv("DB_USER"), System.getenv("DB_PASS"))
                .locations("db/migration")
                .load();

        flyway.migrate();
        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }
}
