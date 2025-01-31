package com.example.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crud.entity.Time;
import com.example.crud.repository.TimeRepository;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public List<Time> listarTodos() {
        return timeRepository.findAll();
    }

    public void salvar(Time time) {
        timeRepository.save(time);
    }
    
    public Time buscarPorId(Long id) {
        return timeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Time não encontrado com ID: " + id));
    }
    
    // Método para deletar um time
    public void deletarTime(Long id) {
        timeRepository.deleteById(id);
    }


}
