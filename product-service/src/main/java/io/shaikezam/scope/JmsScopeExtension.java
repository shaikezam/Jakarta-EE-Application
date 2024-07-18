package io.shaikezam.scope;

import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.spi.*;

public class JmsScopeExtension implements Extension {

    void afterBeanDiscovery(@Observes AfterBeanDiscovery abd, BeanManager manager) {
        BeanManager beanManager = CDI.current().getBeanManager();
        abd.addContext(new JmsScopeContext(beanManager));
        System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY: " + abd);
    }

    void addScope(@Observes final BeforeBeanDiscovery beforeBeanDiscovery) {
        System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
        beforeBeanDiscovery.addScope(JmsScoped.class, true, false);
    }

    void addContext(@Observes final AfterBeanDiscovery afterBeanDiscovery) {
        System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
        BeanManager beanManager = CDI.current().getBeanManager();
        afterBeanDiscovery.addContext(new JmsScopeContext(beanManager));
    }
}