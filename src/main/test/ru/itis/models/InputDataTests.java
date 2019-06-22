package ru.itis.models;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты валидации полей в классе InputData
 *
 * @author Ilshat Rizvanov
 **/
class InputDataTests {
    private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    @Test
    void validatingInputData_withCorrectData_shouldNotHaveViolations() {
        InputData data = InputData.builder()
                .height(8)
                .width(8)
                .start("A1")
                .end("A1")
                .build();
        Set<ConstraintViolation<InputData>> violations = validator.validate(data);
        assertTrue(violations.isEmpty());
    }

    @Test
    void validatingInputData_withInvalidStartPosition_shouldThrowException() {
        InputData data = InputData.builder()
                .height(8)
                .width(8)
                .start("A")
                .end("A1")
                .build();
        Set<ConstraintViolation<InputData>> violations = validator.validate(data);
        assertFalse(violations.isEmpty());
    }

    @Test
    void validatingInputData_withInvalidEndPosition_shouldThrowException() {
        InputData data = InputData.builder()
                .height(8)
                .width(8)
                .start("A1")
                .end("3")
                .build();
        Set<ConstraintViolation<InputData>> violations = validator.validate(data);
        assertFalse(violations.isEmpty());
    }

    @Test
    void validatingInputData_withInvalidWidth_shouldThrowException() {
        InputData data = InputData.builder()
                .height(8)
                .width(-1)
                .start("A1")
                .end("A1")
                .build();
        Set<ConstraintViolation<InputData>> violations = validator.validate(data);
        assertFalse(violations.isEmpty());
    }

    @Test
    void validatingInputData_withInvalidHeight_shouldThrowException() {
        InputData data = InputData.builder()
                .height(0)
                .width(8)
                .start("A1")
                .end("A1")
                .build();
        Set<ConstraintViolation<InputData>> violations = validator.validate(data);
        assertFalse(violations.isEmpty());
    }
}
