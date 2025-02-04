package com.example.crud.securingweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf((csrf) -> csrf.disable());
	    http
	    
	        .authorizeHttpRequests((requests) -> requests
	            .requestMatchers("/", "/home", "/css/**", "/js/**", "/images/**").permitAll() // Libera Home e arquivos estáticos
	            .anyRequest().authenticated() // Todas as outras rotas exigem autenticação
	        )
	        .formLogin((form) -> form
	            .defaultSuccessUrl("/home") // Redireciona para /home após o login
	            .permitAll() // Permite acesso público à página de login padrão
	        )
	        .logout((logout) -> logout
	            .permitAll() // Permite acesso público ao logout
	        );

	    return http.build();
	}

}