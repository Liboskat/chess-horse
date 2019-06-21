package ru.itis.services;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.itis.models.ChessPosition;
import ru.itis.models.HorseCountResult;
import ru.itis.models.InputData;

import javax.validation.Valid;
import java.util.*;

/**
 * Реализация сервиса, подсчитывающего минимальное количество ходов шахматного коня до клетки
 *
 * @author Ilshat Rizvanov
 **/
@Service
@Validated
public class HorseCountServiceImpl implements HorseCountService {

    @Override
    public HorseCountResult getResult(@Valid InputData inputData) {
        //преобразование позиций в объекты для удобной работы
        ChessPosition startPosition = ChessPosition.getFromStringPosition(inputData.getStart());
        ChessPosition endPosition = ChessPosition.getFromStringPosition(inputData.getEnd());

        /*
        создание списка посещенных позиций и очереди позиций,
        добавление начальной позиции в эти коллекции
        */
        Map<ChessPosition, Boolean> visited = new TreeMap<>();
        visited.put(startPosition, true);
        Queue<ChessPosition> queue = new LinkedList<>();
        queue.add(startPosition);

        while (!queue.isEmpty()) {
            //забираем объект из очереди
            ChessPosition node = queue.poll();

            if(endPosition.equals(node)) {
                return HorseCountResult.builder()
                        .result(node.getDistance())
                        .build();
            }
            /*
            получаем доступные из исходной клетки позиции,
            отсеиваем уже посещенные и добавляем оставшиеся в список посещенных и очередь
             */
            getChildren(node, inputData.getWidth(), inputData.getHeight())
                    .stream()
                    .filter((c) -> !visited.containsKey(c))
                    .forEach(c -> {
                        queue.add(c);
                        visited.put(c, true);
                    });
        }

        //до конечной позиции не удалось добраться -> возвращаем -1
        return HorseCountResult.builder().result(-1).build();
    }

    /**
     * Возвращает все позиции на шахматной доске, на которые можно попасть, сходив конем из исходной позиции
     */
    private List<ChessPosition> getChildren(ChessPosition node, int width, int height) {
        List<ChessPosition> children = new ArrayList<>();
        int x = node.getX();
        int y = node.getY();

        //1 вправо и 2 вверх
        if((x + 1 < width) && (y + 2 < height)) {
            children.add(ChessPosition.builder()
                    .x(x + 1)
                    .y(y + 2)
                    .distance(node.getDistance() + 1)
                    .build());
        }
        //1 вправо и 2 вниз
        if((x + 1 < width) && (y - 2 >= 0)) {
            children.add(ChessPosition.builder()
                    .x(x + 1)
                    .y(y - 2)
                    .distance(node.getDistance() + 1)
                    .build());
        }
        //2 вправо и 1 вверх
        if((x + 2 < width) && (y + 1 < height)) {
            children.add(ChessPosition.builder()
                    .x(x + 2)
                    .y(y + 1)
                    .distance(node.getDistance() + 1)
                    .build());
        }
        //2 вправо и 1 вниз
        if((x + 2 < width) && (y - 1 >= 0)) {
            children.add(ChessPosition.builder()
                    .x(x + 2)
                    .y(y - 1)
                    .distance(node.getDistance() + 1)
                    .build());
        }
        //1 влево и 2 вверх
        if((x - 1 >= 0) && (y + 2 < height)) {
            children.add(ChessPosition.builder()
                    .x(x - 1)
                    .y(y + 2)
                    .distance(node.getDistance() + 1)
                    .build());
        }
        //1 влево и 2 вниз
        if((x - 1 >= 0) && (y - 2 >= 0)) {
            children.add(ChessPosition.builder()
                    .x(x - 1)
                    .y(y - 2)
                    .distance(node.getDistance() + 1)
                    .build());
        }
        //2 влево и 1 вверх
        if((x - 2 >= 0) && (y + 1 < height)) {
            children.add(ChessPosition.builder()
                    .x(x - 2)
                    .y(y + 1)
                    .distance(node.getDistance() + 1)
                    .build());
        }
        //2 влево и 1 вниз
        if((x - 2 >= 0) && (y - 1 >= 0)) {
            children.add(ChessPosition.builder()
                    .x(x - 2)
                    .y(y - 1)
                    .distance(node.getDistance() + 1)
                    .build());
        }

        return children;
    }
}
