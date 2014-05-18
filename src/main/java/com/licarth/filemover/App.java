package com.licarth.filemover;

import akka.actor.ActorSystem;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.Getter;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
* Created by thomas on 06/05/14.
*/
@Log4j
@Getter
@Component
public class App implements ApplicationListener<ContextRefreshedEvent>{

    public static App app;
    public static ApplicationContext applicationContext;
    public static long start;

    @Autowired
    UploadService uploadService;
    @Autowired
    JdbcService jdbcService;


    public static void main(String[] args) throws InterruptedException {
        start = System.currentTimeMillis();
        //Configure loggers
//        initialiseloggers();
        applicationContext = new AnnotationConfigApplicationContext("com.licarth.filemover");
        log.debug("line after context :"+ (System.currentTimeMillis() - start));
        //TODO Quelle est la différence ente ContextRefreshedEvent et ContextStartedEvent ?
        //Put nothing here, app is listening to context refresh events.
    }

    private static void initialiseLoggers() {
        ConsoleAppender console = new ConsoleAppender(); //create appender
        String PATTERN = "%d [%p|%c|%C{1}] %m%n";
        console.setLayout(new PatternLayout(PATTERN));
        console.setThreshold(Level.DEBUG);
        console.activateOptions();
        Logger.getLogger("com.licarth.filemover").addAppender(console);
    }

    @Override
    public String toString() {
        return ""+ uploadService.toString();
    }

    public void start(){
        log.debug("Application is starting.");

        createActorSystems();

//        final ActorRef myActor = getContext().actorOf(
//                Props.create(DependencyInjector.class, applicationContext, "MyActor"),
//                "myactor3");

    }

    private void createActorSystems() {
        // make a Config with just your special setting
        Config myConfig =
                ConfigFactory.parseString("something=somethingElse");
        // load the normal config stack (system props,
        // then application.conf, then reference.conf)
        Config regularConfig =
                ConfigFactory.load();
        // override regular stack with myConfig
        Config combined =
                myConfig.withFallback(regularConfig);
        // put the result in between the overrides
        // (system props) and defaults again
        Config complete =
                ConfigFactory.load(combined);
        // create ActorSystem
        ActorSystem system =
                ActorSystem.create("app", complete);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("Context has been refreshed.");
        start();
    }
}