package com.example.crud.controller;

import com.example.crud.entity.Time;
import com.example.crud.service.TimeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/times")
public class TimeController {

	private final TimeService timeService;

	public TimeController(TimeService timeService) {
		this.timeService = timeService;
	}

	// Exibir a página de times
	@GetMapping
	public String listarTimes(Model model) {
		model.addAttribute("times", timeService.listarTodos());
		return "times";
	}

	// Adicionar um novo time
	@PostMapping("/salvar")
	public String salvarTime(@ModelAttribute Time time, Model model) {
	    try {
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
