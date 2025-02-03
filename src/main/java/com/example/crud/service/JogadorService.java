package com.example.crud.service;

import com.example.crud.entity.Jogador;
import com.example.crud.repository.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public void salvar(Jogador jogador) {
        jogadorRepository.save(jogador);
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.findAll();
    }
    
    // Método para deletar um jogador
    public void deletarJogador(Long id) {
        jogadorRepository.deleteById(id);
    }
    
    public Jogador buscarPorId(Long id) {
        return jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
    }

    public void atualizarNome(Long id, String nome) {
        Jogador jogador = buscarPorId(id);
        jogador.setNome(nome);
        jogadorRepository.save(jogador);
    }
}
