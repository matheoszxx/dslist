package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
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
	
	@Transactional(readOnly = true)
	//MÉTODO PARA BUSCAR POR ID
	public GameDTO findById(Long id) {
		//BUSQUEI DO BANCO DE DADOS O A ENTIDADE GAME
		Game result = gameRepository.findById(id).get();
		//CONVERTER UM OBJETO GAME EM UM OBJETO GAMEDTO
		GameDTO dto = new GameDTO(result);
		return dto;	
	}
	
	//ESSA ANOTATION É UMA BOA PRATICA DE PROGRAMAÇÃO, QUE GARANTE QUE A OPERAÇÃO COM O BANCO DE DADOS
	//VAI ACONTECER RESPEITANDO OS PRINCIPIOS DAS TRANSAÇÕES 
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		//GERA UMA CONSULTA NO BANCO DE DADOS
		List<Game> result = gameRepository.findAll();
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
	}
		
		@Transactional(readOnly = true)
		public List<GameMinDTO> findByList(Long listId) {
			//GERA UMA CONSULTA NO BANCO DE DADOS
			List<GameMinProjection> result = gameRepository.searchByList(listId);
			List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
			return dto;
		
	}
}
