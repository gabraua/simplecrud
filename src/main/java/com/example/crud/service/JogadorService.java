package com.example.crud.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.entity.Jogador;
import com.example.crud.repository.JogadorRepository;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public List<Jogador> findAll() {
        return jogadorRepository.findAll();
    }

    public Jogador findById(Long id) {
        return jogadorRepository.findById(id).orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
    }

    public Jogador save(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public void deleteById(Long id) {
        jogadorRepository.deleteById(id);
    }
}
