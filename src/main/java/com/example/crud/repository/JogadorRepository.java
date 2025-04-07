package com.example.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.crud.entity.Jogador;
import com.example.crud.entity.Time;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
	boolean existsByNomeAndTime(String nome, Time time);

    // Busca os jogadores já ordenados pelo número da camisa
    @Query("SELECT j FROM Jogador j ORDER BY j.numeroCamisa ASC")
    List<Jogador> findAllOrderedByNumeroCamisa();
    
	boolean existsByNumeroCamisaAndTime(Integer numeroCamisa, Time time);
}
