package com.jsf.wcanatto.loja_games.bean;

import javax.persistence.*;

@Entity
@Table(name = "game")
public class Game {

	/*
	 * GERAR GETTERS E SETTERS - Alt+shift+S+R
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	private String Titulo;
	private Integer anoFabricacao;
	private String Desenvolvedora;
	private String Publicadora;
	private String Genero;

	public Game(String titulo, Integer anoFab, String desenv, String publica, String gen) {
		this.Titulo = titulo;
		this.anoFabricacao = anoFab;
		this.Desenvolvedora = desenv;
		this.Publicadora = publica;
		this.Genero = gen;
	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public String getTitulo() {
		System.out.println("Chamando Game.getTitulo");
		return this.Titulo;
	}

	// Construtor
	public Game() {
		System.out.println("JSF chamando construtor da classe Game");
		// super();
	}

	public void setTitulo(String titulo) {
		System.out.println("Chamando Game.setTitulo");
		Titulo = titulo;
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getDesenvolvedora() {
		return Desenvolvedora;
	}

	public void setDesenvolvedora(String desenvolvedora) {
		Desenvolvedora = desenvolvedora;
	}

	public String getPublicadora() {
		return Publicadora;
	}

	public void setPublicadora(String publicadora) {
		Publicadora = publicadora;

	}

}
