package ru.itis.services;

import ru.itis.models.HorseCountResult;
import ru.itis.models.InputData;

import javax.validation.Valid;

/**
 * Интерфейс сервиса, подсчитывающего минимальное количество шахматного коня ходов до клетки
 *
 * @author Ilshat Rizvanov
 **/

public interface HorseCountService {
    HorseCountResult getResult(@Valid InputData inputData);
}
