package ru.itis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itis.services.HorseCountService;
import ru.itis.servlets.HorseCountRestServlet;

/**
 * Конфигурация сервлетов
 *
 * @author Ilshat Rizvanov
 **/
@Configuration
public class ServletConfig {
    @Bean
    @Autowired
    public ServletRegistrationBean horseCountServletBean(HorseCountService service) {
        return new ServletRegistrationBean<>(new HorseCountRestServlet(service), "/hourse/servlet/count");
    }
}
