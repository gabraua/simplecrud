package com.example.crud.service;

import com.example.crud.entity.Time;
import com.example.crud.repository.TimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    private final TimeRepository timeRepository;

    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public List<Time> listarTodos() {
        return timeRepository.findAll();
    }
}
