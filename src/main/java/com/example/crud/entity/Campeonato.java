package com.example.crud.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "campeonato")
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nomeCampeonato;

    @OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
    private List<Time> times;

    
    public void setTimes(List<Time> times) { this.times = times; }

	public List<Time> getTimes() {
		// TODO Auto-generated method stub
		return times;
	}
	
}
