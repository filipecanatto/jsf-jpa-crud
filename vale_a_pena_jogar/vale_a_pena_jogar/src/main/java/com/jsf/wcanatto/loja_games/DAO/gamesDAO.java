package com.jsf.wcanatto.loja_games.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.jsf.wcanatto.loja_games.bean.Game;
import com.jsf.wcanatto.loja_games.bean.Genero;

@ManagedBean
public class gamesDAO {

	Game game = new Game();

	public void Salva(Game game) {
		System.out.println("Iniciando Persistencia");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja_games");
		EntityManager em = emf.createEntityManager();
		em.persist(game);
		em.close();
		emf.close();
	}

	public static List<Game> findAll() {
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("select a from Game a", Game.class);
		List<Game> listaGames = new ArrayList<>();
		listaGames = q.getResultList();
		em.close();
		return listaGames;

	}

	public static List<Game> getAllCategories() {
		System.out.println("executando ...");
		EntityManager em = JPAUtil.getEntityManager();
		Query q = em.createQuery("select a from Genero a", Genero.class);
		List<Game> list = new ArrayList<>();
		list = q.getResultList();
		em.close();
		return list;
	}

}
