package com.jsf.wcanatto.vale_a_pena_jogar.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Genero {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	private String Genero;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public void Genero(String genero) {
		this.Genero = genero;
	}

	public Genero() {

	}

	public String getGenero() {
		return Genero;
	}

	public void setGenero(String genero) {
		Genero = genero;
	}

	public Genero(String genero) {
		this.Genero = genero;
	}

}
