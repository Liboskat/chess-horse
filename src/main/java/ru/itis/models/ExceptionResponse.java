package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Объект для преобразования Exception в Json объект
 *
 * @author Ilshat Rizvanov
 **/
@AllArgsConstructor()
@Builder
@Data
public class ExceptionResponse {
    private String message;
    private String status;
}
