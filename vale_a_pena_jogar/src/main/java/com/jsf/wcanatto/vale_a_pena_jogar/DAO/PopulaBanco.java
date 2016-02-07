package com.jsf.wcanatto.vale_a_pena_jogar.DAO;

import javax.persistence.EntityManager;

import com.jsf.wcanatto.vale_a_pena_jogar.bean.Game;
import com.jsf.wcanatto.vale_a_pena_jogar.bean.Genero;

public class PopulaBanco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManager em = JPAUtil.getEntityManager();

		em.getTransaction().begin();

		Game game = geraGame("Batllefield", 2015, "desenv-x", "Eletronic Arts", "First Person Shotter (FPS)");
		em.persist(game);

		Game game1 = geraGame("Call of Duty", 2015, "SledHammer", "publicadora-x", "First Person Shotter (FPS)");
		em.persist(game1);

		Game game2 = geraGame("Hallo", 2014, "300", "publicadora-x", "First Person Shotter (FPS)");
		em.persist(game2);

		Game game3 = geraGame("Forza", 2013, "desenv-x", "publicadora-x", "Corrida");
		em.persist(game3);
		
		Genero gen = geraGenero("First Person Shooter (FPS)");
		em.persist(gen);
		
		Genero gen1 = geraGenero("Corrida");
		em.persist(gen1);
		
		Genero gen2 = geraGenero("RPG");
		em.persist(gen2);

		em.getTransaction().commit();
		em.close();

	}

	public static Game geraGame(String titulo, Integer anoFab, String desenv, String publica, String gen) {
		Game game = new Game(titulo, anoFab, desenv, publica, gen);
		return game;
	}

	public static Genero geraGenero(String genero) {
		Genero gen = new Genero(genero);
		return gen;

	}

}
