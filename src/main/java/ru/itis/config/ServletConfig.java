package ru.itis.config;

import com.fasterxml.jackson.databind.ObjectMapper;
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
    public ServletRegistrationBean horseCountServletBean(HorseCountService service, ObjectMapper objectMapper) {
        return new ServletRegistrationBean<>(new HorseCountRestServlet(service, objectMapper), "/hourse/servlet/count");
    }
}
