package io.shaikezam;

import io.shaikezam.config.ApplicationConfig;
import io.shaikezam.messaging.QueueConstants;
import io.shaikezam.web.listener.FlywayMigrationServletContextListener;
import io.shaikezam.web.listener.messaging.JMSListenerServletContextListener;
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
        context.addEventListener(new JMSListenerServletContextListener(QueueConstants.BROKER_URL, QueueConstants.ORDER_COMPLETED_QUEUE_NAME));
        context.setContextPath("/");
        ServletHolder servletHolder = context.addServlet(ServletContainer.class, "/web/api/*");
        servletHolder.setInitOrder(1);
        servletHolder.setInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS, ApplicationConfig.class.getName());
        servletHolder.setInitParameter("cacheControl","max-age=0,public");
        
        server.setHandler(context);
        server.start();
        server.join();
    }
}