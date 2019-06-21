package ru.itis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * Конфигурация валидации полей
 *
 * @author Ilshat Rizvanov
 **/
@Configuration
public class ValidationConfig {
    public static final String POSITION_VALIDATION_REGEX = "^[A-Za-z]+[1-9][\\d]*$";

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
