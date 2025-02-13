package com.example.crud.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.crud.entity.Campeonato;
import com.example.crud.entity.Time;
import com.example.crud.service.CampeonatoService;
import com.example.crud.service.TimeService;

@Controller
@RequestMapping("/times")
public class TimeController {

	 private final TimeService timeService;
	    private final CampeonatoService campeonatoService;

	    public TimeController(TimeService timeService, CampeonatoService campeonatoService) {
	        this.timeService = timeService;
	        this.campeonatoService = campeonatoService;
	    }

	    @GetMapping
	    public String listarTimes(@RequestParam(required = false) Long campeonatoId, Model model) {
	        return "times";
	    }


	    @PostMapping("/salvar")
	    public String salvarTime(@ModelAttribute Time time, Model model) {
	        try {
	            // Verifica se o time está associado a um campeonato
	            if (time.getCampeonato() == null || time.getCampeonato().getId() == null) {
	                // Cria um campeonato padrão
	                Campeonato campeonatoPadrao = new Campeonato();
	                campeonatoPadrao.setNomeCampeonato("Campeonato Padrão"); // Nome do campeonato padrão
	                campeonatoService.salvar(campeonatoPadrao); // Salva o campeonato padrão no banco de dados

	                // Associa o time ao campeonato padrão
	                time.setCampeonato(campeonatoPadrao);
	            }

	            // Salva o time
	            timeService.salvar(time);
	            return "redirect:/times";
	        } catch (IllegalArgumentException e) {
	            model.addAttribute("erro", e.getMessage()); // Passa a mensagem para a página
	            model.addAttribute("times", timeService.listarTodos()); // Recarrega a lista de times
	            return "times"; // Retorna para a página sem quebrar a aplicação
	        }
	    }


	// Endpoint para deletar um time
	@PostMapping("/deletar/{id}")
	public String deletarTime(@PathVariable Long id) {
	    timeService.deletarTime(id);
	    return "redirect:/times"; // Redireciona de volta para a página de times
	}

}
