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
	    public String listarTimes(@RequestParam(required = false) Long campeonatoId, Model model) {
	        List<Time> times = timeService.listarTodos(); // Carrega todos os times
	        model.addAttribute("times", times); // Adiciona ao modelo
	        return "times"; // Retorna a página com os times carregados
	    }



	    @PostMapping("/salvar")
	    public String salvarTime(@ModelAttribute Time time, Model model) {
	    	try {
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
