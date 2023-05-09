package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//ANOTATION PARA CONFIGURAR A CLASSE JAVA PARA QUE ELA SEJA EQUIVALENTE A UMA TABELA DO BANCO RELACIONAL
@Entity
//CUSTOMIZAR O NOME DA TABELA DO BANCO COM ESSA ANOTATION
@Table(name = "tb_game")
public class Game {
	
	//CONFIGURAR O ID COMO SENDO CHAVE PRIMARIA DA TABELA DO BANCO DE DADOS
	@Id
	//ANOTATION PARA QUE O ID SEJA AUTO INCREMENTADO PELO BANCO DE DADOS
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String title;
	
	//"year" É UMA PALAVRA RESERVADA DO SQL, ENTÃO USAMOS A ANOTATION PARA CUSTOMIZAR O NOME DA COLUNA NO BANCO DE DADOS
	@Column(name = "game_year")
	private Integer year;
	private String genre;
	private String platforms;
	private Double score;
	private String imgUrl;
	
	//ANOTATION PARA A JPA QUANDO GERAR O BANCO, GERE ESSE CAMPO COMO UM TEXTO E NÃO COMO UM VARCHAR(255), POIS EXIGIU O MAXIMO DE LINHAS DA DESCRIÇÃO
	@Column(columnDefinition = "TEXT")
	private String shortDescription;
	
	//ANOTATION PARA A JPA QUANDO GERAR O BANCO, GERE ESSE CAMPO COMO UM TEXTO E NÃO COMO UM VARCHAR(255), POIS EXIGIU O MAXIMO DE LINHAS DA DESCRIÇÃO
	@Column(columnDefinition = "TEXT")
	private String longDescription;
	
	public Game() {
		
	}

	public Game(long id, String title, Integer year, String genre, String platforms, Double score, String imgUrl,
			String shortDescription, String longDescription) {
		this.id = id;
		this.title = title;
		this.year = year;
		this.genre = genre;
		this.platforms = platforms;
		this.score = score;
		this.imgUrl = imgUrl;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
	//MÉTODO PARA COMPARAR DOIS GAMES SE ELES SÃO IGUAIS OU NÃO
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	//MÉTODO PARA COMPARAR DOIS GAMES SE ELES SÃO IGUAIS OU NÃO
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return id == other.id;
	}
	
	
	
	
	
	
}
