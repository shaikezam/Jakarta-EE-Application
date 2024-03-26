package io.shaikezam.config;

import io.shaikezam.web.provider.JacksonObjectMapperProvider;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("/")
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        register(JacksonFeature.class);
        register(JacksonObjectMapperProvider.class);
        property(ServerProperties.PROVIDER_PACKAGES, "io.shaikezam");
    }
}
