package com.example.crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.crud.entity.Time;
import com.example.crud.service.TimeService;

@Controller
public class HomeController {

    private final TimeService timeService;  // Adicionando o TimeService

    public HomeController(TimeService timeService) {
        this.timeService = timeService;  // Inicializando o TimeService
    }
    
    @GetMapping("/")
    public String home(Model model) {
        // Mensagem de boas-vindas
        model.addAttribute("mensagem", "Bem-vindo ao Sistema de Times!");

        // Busca a lista de times
        List<Time> times = timeService.listarTodos();
        model.addAttribute("times", times);

        return "home"; // Retorna a página inicial (home.html)
    }
}


