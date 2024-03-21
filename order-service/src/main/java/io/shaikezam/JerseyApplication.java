package io.shaikezam;

import jakarta.ws.rs.core.Application;

import java.util.HashSet;
import java.util.Set;

public class JerseyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(Person.class);
        return classes;
    }
}