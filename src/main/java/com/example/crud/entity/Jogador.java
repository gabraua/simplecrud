package com.example.crud.entity;


import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "jogador")
public class Jogador {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @ManyToOne
	    @JoinColumn(name = "time_id")
	    private Time time;

	    private String nome;
	    private String email;
	    private String telefone;
	
	    @Column(name = "data_cadastro")
	    private LocalDate dataCadastro;
	}
