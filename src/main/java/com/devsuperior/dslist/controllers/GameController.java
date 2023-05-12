package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

//ANOTATION PARA CONFIGURAR CLASSE PARA SER UM CONTROLADOR
@RestController
//MAPEAR O RECURSO
@RequestMapping(value = "/games")
public class GameController {
	
	//INJETANDO UMA INSTANCIA DO GameService DENTRO DO GameController
	@Autowired
	private GameService gameService;
	
	@GetMapping(value = "/{id}")
	//@PathVariable PARA FAZER QUE O ID SEJA O MESMO QUE EU COLOCAR LÁ NA REQUISIÇÃO NO POSTMAN
	//GameDTO NA FRENTE DO PUBLIC É UM TIPO DE RETORNO
	public GameDTO findById(@PathVariable Long id){
		GameDTO result = gameService.findById(id);
		return result;
	}
	
	//UTILIZAMOS UMA ANOTATION PARA MAPEAR O METODO COM O VERBO HTTP (GET, POST, PUT..)
	@GetMapping
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> result = gameService.findAll();
		return result;
	}
	
}
