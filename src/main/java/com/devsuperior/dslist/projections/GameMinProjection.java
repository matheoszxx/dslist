package com.devsuperior.dslist.projections;

public interface GameMinProjection {
	
	//NESSA INTERFACE VAMOS COLOCAR METODOS GET CORRESPONDE COM A MINHA CONSULTA NO BANCO DE DADOS
	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();

}
