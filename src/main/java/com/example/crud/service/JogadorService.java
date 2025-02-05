package com.example.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crud.entity.Jogador;
import com.example.crud.repository.JogadorRepository;

@Service
public class JogadorService {

    private final JogadorRepository jogadorRepository;

    public JogadorService(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    public void salvar(Jogador jogador) {
    	jogador.setNome(formatarNome(jogador.getNome()));
        jogadorRepository.save(jogador);
    }

    public List<Jogador> listarTodos() {
        return jogadorRepository.findAll();
    }
    
    // Método para deletar um jogador
    public void deletarJogador(Long id) {
        jogadorRepository.deleteById(id);
    }
    
    public Jogador buscarPorId(Long id) {
        return jogadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jogador não encontrado"));
    }

    public void atualizarNome(Long id, String nome) {
        Jogador jogador = buscarPorId(id);
        jogador.setNome(nome);
        jogadorRepository.save(jogador);
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
}
