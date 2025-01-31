package com.example.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.crud.entity.Jogador;
import com.example.crud.entity.Time;
import com.example.crud.service.JogadorService;
import com.example.crud.service.TimeService;

@Controller
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;
    private final TimeService timeService;

    public JogadorController(JogadorService jogadorService, TimeService timeService) {
        this.jogadorService = jogadorService;
        this.timeService = timeService;
    }

    @PostMapping("/salvar")
    public String salvarJogador(@RequestParam String nome, @RequestParam Long timeId) {
        Time time = timeService.buscarPorId(timeId);
        Jogador jogador = new Jogador();
        jogador.setNome(nome);
        jogador.setTime(time);
        jogadorService.salvar(jogador);
        return "redirect:/times";
    }
    // Endpoint para deletar um jogador
    @PostMapping("/deletar/{id}")
    public String deletarJogador(@PathVariable Long id) {
        jogadorService.deletarJogador(id);
        return "redirect:/times"; // Redireciona de volta para a página de times
    }
}
