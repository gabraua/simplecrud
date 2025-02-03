package com.example.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    
 // Endpoint para carregar a página de edição
    @GetMapping("/edit/{id}")
    public String editarJogador(@PathVariable Long id, Model model) {
        Jogador jogador = jogadorService.buscarPorId(id);
        model.addAttribute("jogador", jogador);
        return "edit"; // Nome da página HTML (editar-jogador.html)
    }

    // Endpoint para processar a atualização do nome do jogador
    @PostMapping("/atualizar/{id}")
    public String atualizarJogador(@PathVariable Long id, @RequestParam String nome) {
        jogadorService.atualizarNome(id, nome);
        return "redirect:/times"; // Redireciona de volta para a lista de times
    }
}
