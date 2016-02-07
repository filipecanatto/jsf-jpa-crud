package com.jsf.wcanatto.vale_a_pena_jogar.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsf.wcanatto.vale_a_pena_jogar.DAO.JPAUtil;
import com.jsf.wcanatto.vale_a_pena_jogar.DAO.gamesDAO;
import com.jsf.wcanatto.vale_a_pena_jogar.bean.*;

@ManagedBean
@RequestScoped
public class GamesManagedBean {

	public List<Game> listaGames = new ArrayList();
	public Game game = new Game();
	public gamesDAO dao = new gamesDAO();
	public String genero_val;

	public String getGenero_val() {
		return genero_val;
	}

	public void setGenero_val(String genero_val) {
		this.genero_val = genero_val;
		game.setGenero(genero_val);
	}

	public gamesDAO getDao() {
		return dao;
	}

	public void setDao(gamesDAO dao) {
		this.dao = dao;
	}

	public GamesManagedBean() {
		System.out.println("Executando construtor da classe GamesMB");
		listaGames = gamesDAO.findAll();
	}

	/*
	 * A JSF precisa desse m�todo para adquirir a referencia do objeto "game"
	 */
	public Game getGame() {
		return this.game;
	}

	/*
	 * A JSF precisa desse m�todo para transmitir/passar o objeto "game" como
	 * parametro a uma fun��o
	 */
	public void setGame(Game game) {
		this.game = game;
	}

	/*
	 * public void TesteInterface(){ System.out.println("Loja de Games - Teste"
	 * ); }
	 */

	/*
	 * Persistencia sem usar a classe JPAUtil public void SalvaBD(Game game){
	 * System.out.println("Iniciando Persistencia");
	 * 
	 * 
	 * //Objeto responsavel por pegar as informa��es de conex�o descritas no
	 * "persistence.xml" EntityManagerFactory emf =
	 * Persistence.createEntityManagerFactory("loja_games");
	 * 
	 * //Objeto responsavel por abrir uma se��o com as informa��es de conex�o
	 * adquiridas pelo "EntitiManagerFactory" EntityManager em =
	 * emf.createEntityManager();
	 * 
	 * //Objeto responsavel por criar uma transa��o - Obrigat�rio para
	 * manipula��o do bd EntityTransaction tx = em.getTransaction();
	 * 
	 * //Inicio da transa��o tx.begin();
	 * 
	 * //Manipulacao do BD em.persist(game);
	 * 
	 * //Fim da transa��o tx.commit();
	 * 
	 * //Liberando recursos em.close(); emf.close(); }
	 */

	// Persistencia usando a classe JPAUtil
	public void SalvaBD(Game game) {
		System.out.println("inicinado persistencia de dados");
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(game);
		em.getTransaction().commit();
		em.close();

		this.game = new Game();

	}

	// Retorna uma lista para ser usada no componente "dataTable"
	public List<Game> getGames() {

		System.out.println("Entrando no m�todo getListGame");
		return listaGames;

	}

	public void exclui(Game game) {
		System.out.println("realizando exclus�o do game: " + game.getTitulo());
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		game = em.merge(game);
		em.remove(game);
		tx.commit();
		em.close();

	}

	public List<Game> getGenero() {
		System.out.println("adquirindo lista de genero");
		List<Game> list = gamesDAO.getAllCategories();

		return list;
	}

}
