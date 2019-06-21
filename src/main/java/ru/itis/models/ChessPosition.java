package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс, описывающий информацию о расположении шахматной клетки и расстояние от начальной клетки
 *
 * @author Ilshat Rizvanov
 **/
@AllArgsConstructor
@Builder
@Data
@EqualsAndHashCode(exclude = {"distance"})
public class ChessPosition implements Comparable<ChessPosition> {
    private int x;
    private int y;
    private int distance;
    public static final Pattern POSITION_PATTERN = Pattern.compile("^([A-Z]+)([\\d]+)?");

    /**
     * Преобразует строку с расположением клетки на шахматной доске в объект
     */
    public static ChessPosition getFromStringPosition(String position) {
        position = position.toUpperCase();
        Matcher m = POSITION_PATTERN.matcher(position);

        if(m.matches()) {
            return ChessPosition.builder()
                    .x(transformToNumber(m.group(1)))
                    .y(Integer.parseInt(m.group(2)) - 1)
                    .distance(0)
                    .build();
        } else {
            throw new IllegalArgumentException(position + " is not position");
        }
    }

    /**
     * Преобразует буквенное обозначение столбцов (как в Excel) в числовое
     */
    private static int transformToNumber(String x) {
        int result = 0;
        for (int i = 0; i < x.length(); i++)
        {
            result *= 26;
            result += (x.charAt(i) - 'A' + 1);
        }
        return result - 1;
    }

    @Override
    public int compareTo(ChessPosition o) {
        if(this.y < o.y) {
            return -1;
        } else if (this.y > o.y){
            return 1;
        } else {
            return Integer.compare(this.x, o.x);
        }
    }
}
