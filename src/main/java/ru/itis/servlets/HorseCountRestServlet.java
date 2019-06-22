package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import ru.itis.models.ExceptionResponse;
import ru.itis.models.InputData;
import ru.itis.services.HorseCountService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.io.IOException;
import java.io.Writer;

/**
 * REST сервлет для подсчета минимального количество ходов коня до конечного положения
 *
 * @author Ilshat Rizvanov
 **/

public class HorseCountRestServlet extends HttpServlet {
    private final HorseCountService horseCountService;
    private final ObjectMapper objectMapper;

    public HorseCountRestServlet(HorseCountService horseCountService, ObjectMapper objectMapper) {
        this.horseCountService = horseCountService;
        this.objectMapper = objectMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Writer w = resp.getWriter();

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");

        try {
            resp.setStatus(HttpServletResponse.SC_OK);
            objectMapper.writeValue(w, horseCountService.getResult(InputData.builder()
                    .width(Integer.parseInt(req.getParameter("width")))
                    .height(Integer.parseInt(req.getParameter("height")))
                    .start(req.getParameter("start"))
                    .end(req.getParameter("end"))
                    .build()));
        } catch (IllegalArgumentException | ConstraintViolationException e) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            objectMapper.writeValue(w, ExceptionResponse.builder()
                    .message(e.getMessage())
                    .status(HttpStatus.BAD_REQUEST.toString())
                    .build());
        } finally {
            w.close();
        }
    }
}
