package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entity.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
