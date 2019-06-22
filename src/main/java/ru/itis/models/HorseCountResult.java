package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Класс-обертка результата подсчета
 *
 * @author Ilshat Rizvanov
 **/
@AllArgsConstructor()
@Builder
@Data
public class HorseCountResult {
    private Integer result;
}
