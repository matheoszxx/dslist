package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.devsuperior.dslist.dto.GameListDTO;

import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;


//REGISTRANDO CAMPONENTE COMUM NO FRAMEWORK (SPRING)
@Service //OU
//@Component REGISTRA TAMBÉM
public class GameListService {
	 
	//INJETANDO UMA INSTANCIA DO GameListRepository DENTRO DO GameListService
	//COMO NA ARQUITETURA DE CAMADAS O GameListRepository ESTÁ EM BAIXO E O GameListService EM CIMA...
	//ENTÃO INJETO UMA INSTANCIA DO GameListRepository DENTRO DO GameListService UTILIZANDO A ANOTATION...
	//@Autowired
	@Autowired
	private GameListRepository gameListRepository;
	
	//ESSA ANOTATION É UMA BOA PRATICA DE PROGRAMAÇÃO, QUE GARANTE QUE A OPERAÇÃO COM O BANCO DE DADOS
	//VAI ACONTECER RESPEITANDO OS PRINCIPIOS DAS TRANSAÇÕES 
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		//GERA UMA CONSULTA NO BANCO DE DADOS
		List<GameList> result = gameListRepository.findAll();//É O CONSTRUTOR DA CLASSE GameListDTO
		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
	}
	
	
}
