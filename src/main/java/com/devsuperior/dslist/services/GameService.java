package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

//REGISTRANDO CAMPONENTE COMUM NO FRAMEWORK (SPRING)
@Service //OU
//@Component REGISTRA TAMBÉM
public class GameService {
	 
	//INJETANDO UMA INSTANCIA DO GameRepository DENTRO DO GameService
	//COMO NA ARQUITETURA DE CAMADAS O GameRepository ESTÁ EM BAIXO E O GameService EM CIMA...
	//ENTÃO INJETO UMA INSTANCIA DO GameRepository DENTRO DO GameService UTILIZANDO A ANOTATION...
	//@Autowired
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll() {
		//GERA UMA CONSULTA NO BANCO DE DADOS
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
		
	}
}
