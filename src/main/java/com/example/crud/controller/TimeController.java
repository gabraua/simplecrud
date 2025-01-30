package com.example.crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crud.entity.Time;
import com.example.crud.service.TimeService;

@Controller
@RequestMapping("/times")
public class TimeController {

    private final TimeService timeService;

    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping
    public String listarTimes(Model model) {
        List<Time> times = timeService.listarTodos();
        model.addAttribute("times", times);
        return "times";  // Nome do template Thymeleaf (times.html)
    }
}


