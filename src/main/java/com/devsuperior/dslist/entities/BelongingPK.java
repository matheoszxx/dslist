package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//ANOTATION PARA ENCAPSULAR DOIS ATRIPUTOS EM UMA CLASSE SÓ, PARA QUANDO EU RELACIONAR...
//A CLASSE BelongingPK EM FORMA DE OBJETO NA CLASSE Belonging VAI REPRESENTAR DOIS CAMPOS NA TABELA DO BANCO RELACIONAL
@Embeddable
public class BelongingPK {
	
	//CONFIGURAÇÃO DA JPA PARA FAZER O MAPEAMENTO OBJETO RELACIONAL
	//ISSO QUE FOI FEITO VAI SER MAPEADO PARA DOIS CAMPOS "CHAVE ESTRANGEIRA" NA TABELA
	@ManyToOne
	//REGISTRANDO O NOME DA CHAVE ESTRANGEIRA 
	@JoinColumn(name = "game_id")
	private Game game;
	
	@ManyToOne
	@JoinColumn(name = "list_id")
	private GameList list;
	
	public BelongingPK() {
		
	}

	public BelongingPK(Game game, GameList list) {
		super();
		this.game = game;
		this.list = list;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return list;
	}

	public void setList(GameList list) {
		this.list = list;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
	
	
}
