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
		time.setNome(formatarNome(time.getNome()));
		// Busca todos os times no banco de dados
		List<Time> times = timeRepository.findAll();

		// Verifica se já existe um time com o mesmo nome
		for (Time t : times) {
			if (t.getNome().equalsIgnoreCase(time.getNome())) {
				throw new IllegalArgumentException("Já existe um time com o nome: " + time.getNome());
			}
		}

		// Se não existir, salva o novo time
		timeRepository.save(time);
	}

	private String formatarNome(String nome) {
	    if (nome == null || nome.trim().isEmpty()) {
	        return nome; // Retorna o mesmo valor se for nulo ou vazio
	    }
	    
	    nome = nome.trim().toLowerCase(); // Converte tudo para minúsculas primeiro
	    
	    // Divide o nome em palavras e capitaliza cada uma
	    String[] palavras = nome.split("\\s+"); // Divide por espaços
	    StringBuilder nomeFormatado = new StringBuilder();

	    for (String palavra : palavras) {
	        if (!palavra.isEmpty()) {
	            nomeFormatado.append(Character.toUpperCase(palavra.charAt(0))) // Primeira letra maiúscula
	                         .append(palavra.substring(1)) // Restante minúsculo
	                         .append(" "); // Adiciona espaço entre palavras
	        }
	    }
	    
	    return nomeFormatado.toString().trim(); // Remove espaço extra no final
	}

	public Time buscarPorId(Long id) {
		return timeRepository.findById(id).orElseThrow(() -> new RuntimeException("Time não encontrado com ID: " + id));
	}

	// Método para deletar um time
	public void deletarTime(Long id) {
		timeRepository.deleteById(id);
	}

}
