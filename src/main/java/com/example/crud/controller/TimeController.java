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
	public String salvarTime(@ModelAttribute Time time) {
		timeService.salvar(time);
		return "redirect:/times"; // Redireciona de volta para a lista de times
	}

	// Endpoint para deletar um time
	@PostMapping("/deletar/{id}")
	public String deletarTime(@PathVariable Long id) {
	    timeService.deletarTime(id);
	    return "redirect:/times"; // Redireciona de volta para a página de times
	}

}
