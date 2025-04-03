package com.senai.ecommerce.dto;

import com.senai.ecommerce.entities.Categoria;

public class CategoriaDTO {

	private Long id;
	private String nome;
	
	
	public CategoriaDTO() {
		
	}

	public CategoriaDTO(Categoria cat) {

		id = cat.getId();
		nome = cat.getNome();
	}

	public CategoriaDTO(Long id, String nome) {

		this.id = id;
		this.nome = nome;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
