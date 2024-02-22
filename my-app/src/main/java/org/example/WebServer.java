package org.example;

import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import java.util.logging.Logger;

public class WebServer {

    private static final Logger logger = Logger.getLogger(WebServer.class.getName());

    public static void main(String[] args) throws InterruptedException {
        logger.info("Starting server...");
        JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
        factoryBean.setResourceClasses(SimpleController.class);
        factoryBean.setProvider(new JacksonJsonProvider());
        factoryBean.setAddress("http://0.0.0.0:333/");
        Server server = factoryBean.create();
        server.start();
        Thread.currentThread().join();
    }
}