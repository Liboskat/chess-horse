package ru.itis.servlets;

import ru.itis.models.InputData;
import ru.itis.services.HorseCountService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * REST сервлет для подсчета минимального количество ходов коня до конечного положения
 *
 * @author Ilshat Rizvanov
 **/

public class HorseCountRestServlet extends HttpServlet {
    private final HorseCountService horseCountService;

    public HorseCountRestServlet(HorseCountService horseCountService) {
        this.horseCountService = horseCountService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Writer w = resp.getWriter();
        w.write(horseCountService.getResult(InputData.builder()
                        .width(Integer.parseInt(req.getParameter("width")))
                        .height(Integer.parseInt(req.getParameter("height")))
                        .start(req.getParameter("start"))
                        .end(req.getParameter("end"))
                        .build())
                .toJson());

        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
