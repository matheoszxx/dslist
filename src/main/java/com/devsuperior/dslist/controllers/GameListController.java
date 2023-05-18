package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

//ANOTATION PARA CONFIGURAR CLASSE PARA SER UM CONTROLADOR
@RestController
//MAPEAR O RECURSO
@RequestMapping(value = "/lists")
public class GameListController {
	
	//INJETANDO UMA INSTANCIA DO GameListService DENTRO DO GameListController
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	//UTILIZAMOS UMA ANOTATION PARA MAPEAR O METODO COM O VERBO HTTP (GET, POST, PUT..)
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDTO> finByList(@PathVariable Long listId){
		List<GameMinDTO> result = gameService.findByList(listId);
		return result;
	}
}
