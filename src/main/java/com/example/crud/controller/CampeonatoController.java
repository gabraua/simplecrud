package com.example.crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crud.entity.Campeonato;
import com.example.crud.service.CampeonatoService;

@Controller
@RequestMapping("/campeonatos")
public class CampeonatoController {
    private final CampeonatoService campeonatoService;

    public CampeonatoController(CampeonatoService campeonatoService) {
        this.campeonatoService = campeonatoService;
    }

    @GetMapping
    public String listarCampeonatos(Model model) {
        List<Campeonato> campeonatos = campeonatoService.listarTodos();
        model.addAttribute("campeonatos", campeonatos);
        return "campeonatos";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Campeonato campeonato) {
        campeonatoService.salvar(campeonato);
        return "redirect:/campeonatos";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        campeonatoService.deletar(id);
        return "redirect:/campeonatos";
    }
}
