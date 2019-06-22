package ru.itis.services;

import org.junit.jupiter.api.Test;
import ru.itis.models.InputData;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit тесты класса HorseCountService
 *
 * @author Ilshat Rizvanov
 **/

class HorseCountServiceTests {
    private final HorseCountService horseCountService = new HorseCountServiceImpl();

    @Test
    void getResult_withSameStartAndEnd_shouldBeZero() {
        InputData data = InputData.builder()
                .height(8)
                .width(8)
                .start("A1")
                .end("A1")
                .build();
        assertEquals(0,
                horseCountService.getResult(data).getResult().intValue());
    }

    @Test
    void getResult_withOneRealMove_shouldBeOne() {
        InputData data = InputData.builder()
                .height(8)
                .width(8)
                .start("A1")
                .end("C2")
                .build();
        assertEquals(1,
                horseCountService.getResult(data).getResult().intValue());
    }

    @Test
    void getResult_withTwoRealMoves_shouldBeTwo() {
        InputData data = InputData.builder()
                .height(8)
                .width(8)
                .start("D4")
                .end("A1")
                .build();
        assertEquals(2,
                horseCountService.getResult(data).getResult().intValue());
    }

    @Test
    void getResult_withUnreachableSquare_shouldBeMinusOne() {
        InputData data = InputData.builder()
                .height(2)
                .width(2)
                .start("A1")
                .end("B2")
                .build();
        assertEquals(-1,
                horseCountService.getResult(data).getResult().intValue());
    }
}
