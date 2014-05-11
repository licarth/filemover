package com.licarth.filemover;

import lombok.Getter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by thomas on 06/05/14.
 */
@Log
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
        applicationContext = new AnnotationConfigApplicationContext("com.licarth.filemover");
        log.info("line after context :"+ (System.currentTimeMillis() - start));
        //TODO Quelle est la différence ente ContextRefreshedEvent et ContextStartedEvent ?
        //Put nothing here, app is listening to context refresh events.
//        app = applicationContext.getBean(App.class);
//        app.start();
    }

    @Override
    public String toString() {
        return ""+ uploadService.toString();
    }

    public void start(){
        log.info("Application is starting.");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Context has been refreshed.");
        start();
    }
}