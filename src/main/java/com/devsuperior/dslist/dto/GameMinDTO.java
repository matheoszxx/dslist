package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;



public class GameMinDTO {
	
	private long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	public GameMinDTO() {
		
	}
	
	//CONSTRUTOR QUE RECEBE A ENTIDADE (COPIA OS DADOS DA ENTIDADE)...
	//...INSTANCIANDO GameMinDTO APARTIR DE UM OBJETO GAME, COPIANDO OS DADOS DO GAME PARA DO GAMEMINDTO
	public GameMinDTO(Game entity) {
		id = entity.getId();
		title = entity.getTitle();
		year = entity.getYear();
		imgUrl = entity.getImgUrl();
		shortDescription = entity.getShortDescription();
	}
	
	//SÓ VAMOS PRECISAR DOS GETTERS NO DTO
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	
	
	

}
