package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.models.HorseCountResult;
import ru.itis.models.InputData;
import ru.itis.services.HorseCountService;

/**
 * REST Spring контроллер для подсчета минимального количество ходов коня до конечного положения
 *
 * @author Ilshat Rizvanov
 **/

@Controller
@RequestMapping("/hourse/rest/count")
public class HorseCountRestController {
    private final HorseCountService horseCountService;

    @Autowired
    public HorseCountRestController(HorseCountService horseCountService) {
        this.horseCountService = horseCountService;
    }

    @GetMapping
    public ResponseEntity<HorseCountResult> getResult(InputData data) {
        return ResponseEntity.ok(horseCountService.getResult(data));
    }
}
