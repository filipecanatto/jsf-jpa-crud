package com.jsf.wcanatto.loja_games.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("loja_games");
	
	public static EntityManager getEntityManager(){
		System.out.println("JPAUtil - executando emf");
		return emf.createEntityManager();
	}
	
	public JPAUtil(){
		System.out.println("JPAUtil - executando construtor");
	}

}
