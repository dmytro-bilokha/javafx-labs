package com.github.dmytrobilokha.cdifx.boot;

import javafx.fxml.FXMLLoader;
import javafx.util.Callback;
import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ResourceBundle;

public class FXMLLoaderProducer {

    private final BeanManager beanManager;

    @Inject
    public FXMLLoaderProducer(BeanManager beanManager) {
        System.out.println(Thread.currentThread().getName() + ' ' + Thread.currentThread().getId()
                + " Producers constructor called with " + beanManager);
        this.beanManager = beanManager;
    }

    @Produces
    @Dependent
    public FXMLLoader produce(InjectionPoint injectionPoint) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        System.out.println(Thread.currentThread().getName() + ' ' + Thread.currentThread().getId() + " PRODUCER PRODUCE fxmlLoader=" + fxmlLoader);
        fxmlLoader.setControllerFactory( beanClass -> {
            System.out.println(Thread.currentThread().getName() + ' ' + Thread.currentThread().getId() + " FACTORY CONTROLLER PRODUCE");
            ContainerLifecycle lifecycle = WebBeansContext.getInstance().getService(ContainerLifecycle.class);
            //BeanManager beanManager = lifecycle.getBeanManager();
                    Bean<?> bean = beanManager.resolve(beanManager.getBeans(beanClass));
                    return beanManager.getReference(bean, bean.getBeanClass(), beanManager.createCreationalContext(bean));
                }

        );
        fxmlLoader.setResources(ResourceBundle.getBundle("messages"));
        return fxmlLoader;
    }

}
