package com.nelioalves.cursomc.model.dto;

public class CategoriaDTO {
	private Integer id;
	private String nome;

	public CategoriaDTO() {
	}

	public CategoriaDTO(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
