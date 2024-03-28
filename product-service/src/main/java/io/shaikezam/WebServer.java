package io.shaikezam;

import io.shaikezam.config.ApplicationConfig;
import io.shaikezam.web.listener.FlywayMigrationServletContextListener;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;

import java.util.logging.Logger;

@ApplicationScoped
public class WebServer {

    private static final Logger logger = Logger.getLogger(WebServer.class.getName());

    public static void main(String[] args) throws Exception {
        logger.info("Starting server...");

        Server server = new Server(8080);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addEventListener(new FlywayMigrationServletContextListener());
        context.setContextPath("/");
        ServletHolder servletHolder = context.addServlet(ServletContainer.class, "/web/api/*");
        servletHolder.setInitOrder(1);
        servletHolder.setInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, ApplicationConfig.class.getName());

        server.setHandler(context);
        server.start();
        server.join();
    }
}