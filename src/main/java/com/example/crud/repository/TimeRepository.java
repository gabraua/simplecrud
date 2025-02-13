package com.example.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entity.Time;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
	
    List<Time> findByCampeonatoId(Long campeonatoId);

}
