package com.github.dmytrobilokha.cdifx.boot;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

/**
 * The class to manage CDI container
 */
class ContainerManager {

    private ContainerLifecycle lifecycle = null;

    ContainerManager() {
        //Package private constructor to restrict who are allowed to start the container
    }

    void startContainer() {
        lifecycle = WebBeansContext.getInstance().getService(ContainerLifecycle.class);
        lifecycle.startApplication(null);
    }

    void stopContainer() {
        if (lifecycle == null)
            throw new IllegalStateException("Unable to stop the container, seems like it wasn't started");
        lifecycle.stopApplication(null);
    }

    <T> T getBeanByClass(Class<T> beanClass) {
        BeanManager beanManager = lifecycle.getBeanManager();
        Bean<?> bean = beanManager.resolve(beanManager.getBeans(beanClass));
        return  (T) beanManager.getReference(bean, bean.getBeanClass(), beanManager.createCreationalContext(bean));
    }

}
