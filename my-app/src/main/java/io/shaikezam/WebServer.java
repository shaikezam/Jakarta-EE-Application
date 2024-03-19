package io.shaikezam;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.configuration.FluentConfiguration;
import org.glassfish.jersey.servlet.ServletContainer;

import java.util.logging.Logger;

public class WebServer {

    private static final Logger logger = Logger.getLogger(WebServer.class.getName());

    public static void main(String[] args) throws Exception {
        logger.info("Starting server...");

        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:mariadb://db:3306/mydb", "admin", "admin")
                .locations("db/migration")
                .load();

        flyway.migrate();
        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        ServletHolder servletHolder = context.addServlet(ServletContainer.class, "/rest/*");
        servletHolder.setInitOrder(1);
        servletHolder.setInitParameter("jersey.config.server.provider.packages", SimpleResource.class.getPackageName());

        server.setHandler(context);
        server.start();
        server.join();
    }
}