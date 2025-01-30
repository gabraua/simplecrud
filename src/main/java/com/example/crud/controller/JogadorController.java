package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crud.entity.Jogador;
import com.example.crud.service.JogadorService;

@Controller
@RequestMapping("/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @GetMapping
    public List<Jogador> getAllJogadores() {
        return jogadorService.findAll();
    }

    @GetMapping("/{id}")
    public Jogador getJogadorById(@PathVariable Long id) {
        return jogadorService.findById(id);
    }

    @PostMapping
    public Jogador createJogador(@RequestBody Jogador jogador) {
        return jogadorService.save(jogador);
    }

    @PutMapping("/{id}")
    public Jogador updateJogador(@PathVariable Long id, @RequestBody Jogador jogador) {
        jogador.setId(id);
        return jogadorService.save(jogador);
    }

    @DeleteMapping("/{id}")
    public void deleteJogador(@PathVariable Long id) {
        jogadorService.deleteById(id);
    }
}

