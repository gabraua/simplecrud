package com.example.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crud.entity.Campeonato;
import com.example.crud.repository.CampeonatoRepository;

@Service
public class CampeonatoService {
    private final CampeonatoRepository campeonatoRepository;

    public CampeonatoService(CampeonatoRepository campeonatoRepository) {
        this.campeonatoRepository = campeonatoRepository;
    }

    public List<Campeonato> listarTodos() {
        return campeonatoRepository.findAll();
    }

    public void salvar(Campeonato campeonato) {
        if (campeonato.getNomeCampeonato() == null || campeonato.getNomeCampeonato().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do campeonato não pode ser nulo ou vazio.");
        }
        // Lógica para salvar o campeonato no banco de dados
        campeonatoRepository.save(campeonato);
    }

    public void deletar(Long id) {
        campeonatoRepository.deleteById(id);
    }

    public Campeonato buscarPorId(Long id) {
        return campeonatoRepository.findById(id).orElse(null);
    }
}
