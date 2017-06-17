package com.github.dmytrobilokha.cdifx.boot;

import javafx.fxml.FXMLLoader;
import javafx.util.Callback;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
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
        fxmlLoader.setControllerFactory(new ControllerFactory());
        fxmlLoader.setResources(ResourceBundle.getBundle("messages"));
        return fxmlLoader;
    }

    private class ControllerFactory implements Callback<Class<?>, Object> {

        @Override
        public Object call(Class controllerClass) {
            Bean<?> bean = beanManager.resolve(beanManager.getBeans(controllerClass));
            Object controllerObject = beanManager.getReference(bean
                    , bean.getBeanClass(), beanManager.createCreationalContext(bean));
            if (controllerObject == null)
                throw new IllegalArgumentException("Failed to get instance of controller for class " + controllerClass);
            return controllerObject;
        }

    }
}
