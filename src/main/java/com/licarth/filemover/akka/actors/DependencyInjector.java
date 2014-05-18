package com.licarth.filemover.akka.actors;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by thomas on 12/05/14.
 */
@Component
@Log4j
public abstract class DependencyInjector<T extends Actor> implements IndirectActorProducer {

    final ApplicationContext applicationContext;

    @Autowired
    protected DependencyInjector(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public T produce() {
        T result = null;
        log.debug("Dependency injector created.");
        // obtain fresh Actor instance from DI framework ...
        return result;
    }
}