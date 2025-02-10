package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entity.Jogador;
import com.example.crud.entity.Time;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
	boolean existsByNomeAndTime(String nome, Time time);

	boolean existsByNumeroCamisaAndTime(Integer numeroCamisa, Time time);
}
