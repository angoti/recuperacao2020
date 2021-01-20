package com.angoti.recuperacao.dominio;

public class Aluno {
	private int id;
	private String nome;
	
	public Aluno() {
		super();
	}

	public Aluno(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

}
