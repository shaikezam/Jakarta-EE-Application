package io.shaikezam.web.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.flywaydb.core.Flyway;

public class FlywayMigrationServletContextListener implements ServletContextListener {

    private String dbHost = System.getenv("DB_HOST");
    private String dbPort = System.getenv("DB_PORT");
    private String dbName = System.getenv("DB_NAME");
    private String dbUrl = String.format("jdbc:mariadb://%s:%s/%s", dbHost, dbPort, dbName);

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
