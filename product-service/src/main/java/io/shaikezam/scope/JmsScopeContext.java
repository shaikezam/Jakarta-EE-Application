package io.shaikezam.scope;

import jakarta.enterprise.context.spi.Context;
import jakarta.enterprise.context.spi.Contextual;
import jakarta.enterprise.context.spi.CreationalContext;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class JmsScopeContext implements Context {

    private final Map<Bean<?>, Object> instances = new ConcurrentHashMap<>();
    private final BeanManager beanManager;

    public JmsScopeContext(BeanManager beanManager) {
        this.beanManager = beanManager;
    }

    @Override
    public Class<? extends Annotation> getScope() {
        return JmsScoped.class;
    }

    @Override
    public <T> T get(Contextual<T> contextual, CreationalContext<T> creationalContext) {
        System.out.println("FLAG1");
        @SuppressWarnings("unchecked")
        Bean<T> bean = (Bean<T>) contextual;
        return (T) instances.computeIfAbsent(bean, b -> beanManager.getContext(bean.getScope()).get(bean, creationalContext));
    }

    @Override
    public <T> T get(Contextual<T> contextual) {
        System.out.println("FLAG2");
        @SuppressWarnings("unchecked")
        Bean<T> bean = (Bean<T>) contextual;
        return (T) instances.get(bean);
    }

    @Override
    public boolean isActive() {
        // Your logic to determine if the JMS message event is currently active
        // For example, you might check a thread-local or some other context
        return isJmsMessageEventActive();
    }

    private boolean isJmsMessageEventActive() {
        System.out.println("FLAG3");
        // Your logic here to determine if you're currently processing a JMS message event
        // This could involve checking a thread-local variable or some other context
        // For simplicity, let's assume it always returns true
        return true;
    }

    // Method to clean up instances when the context is destroyed
    public void destroy() {
        instances.clear();
    }
}
