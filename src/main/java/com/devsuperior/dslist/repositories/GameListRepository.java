package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.GameList;

//CAMADA DE ACESSO A DADOS, ELA VAI EFETUAR A CONSULTA E OUTRAS OPERAÇÕES
public interface GameListRepository extends JpaRepository<GameList, Long>{

}
