package io.shaikezam;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.flywaydb.core.Flyway;
import org.glassfish.jersey.servlet.ServletContainer;

import javax.sql.DataSource;
import java.util.logging.Logger;

public class WebServer {

    private static final Logger logger = Logger.getLogger(WebServer.class.getName());

    public static void main(String[] args) throws Exception {
        logger.info("Starting server...");

        String dbHost = System.getenv("DB_HOST");
        String dbPort = System.getenv("DB_PORT");
        String dbUrl = String.format("jdbc:mariadb://%s:%s/%s", dbHost, dbPort, "order_service");
        Flyway flyway = Flyway.configure()
                .dataSource(dbUrl, System.getenv("DB_USER"), System.getenv("DB_PASS"))
                .locations("db/migration")
                .load();

        flyway.migrate();

        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addEventListener(new ServletContextListener() {
            @Override
            public void contextInitialized(ServletContextEvent sce) {
                logger.info("Start...");
                ServletContextListener.super.contextInitialized(sce);
            }

            @Override
            public void contextDestroyed(ServletContextEvent sce) {
                ServletContextListener.super.contextDestroyed(sce);
            }
        });
        context.setContextPath("/");
        ServletHolder servletHolder = context.addServlet(ServletContainer.class, "/rest/*");
        servletHolder.setInitOrder(1);
        servletHolder.setInitParameter("jersey.config.server.provider.packages", SimpleResource.class.getPackageName());

        server.setHandler(context);
        server.start();
        server.join();
    }
}