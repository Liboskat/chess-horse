package ru.itis.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Главный класс приложения
 *
 * @author Ilshat Rizvanov
 **/
@ComponentScan({"ru.itis.app", "ru.itis.controllers", "ru.itis.services", "ru.itis.config"})
@SpringBootApplication
public class Application {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        context = SpringApplication.run(Application.class, args);
    }

    public static ConfigurableApplicationContext getContext() {
        return context;
    }
}
