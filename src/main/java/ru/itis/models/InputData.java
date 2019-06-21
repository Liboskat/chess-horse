package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.itis.config.ValidationConfig;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

/**
 * Класс-обертка входных данных задачи
 *
 * @author Ilshat Rizvanov
 **/
@AllArgsConstructor
@Builder
@Data
public class InputData {
    @Min(value = 1, message = "Width must be more than 0")
    private Integer width;

    @Min(value = 1, message = "Height must be more than 0")
    private Integer height;

    @Pattern(regexp = ValidationConfig.POSITION_VALIDATION_REGEX,
            message = "Position must contain at first letters, then numbers > 0")
    private String start;

    @Pattern(regexp = ValidationConfig.POSITION_VALIDATION_REGEX,
            message = "Position must contain at first letters, then numbers > 0")
    private String end;
}
