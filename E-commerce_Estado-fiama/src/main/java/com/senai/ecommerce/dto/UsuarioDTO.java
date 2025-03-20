package com.senai.ecommerce.dto;

import java.util.ArrayList;

import java.util.List;

import com.senai.ecommerce.entities.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String senha;
	
	private List<PedidoDTO> pedido = new ArrayList<>();
	

	public UsuarioDTO() {
		
	}


	public UsuarioDTO(Long id, String nome, String email, String telefone, String senha) {
	
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		
	}

	public UsuarioDTO(Usuario user) {
	
		id = user.getId();
		nome = user.getNome();
		email = user.getEmail();
		telefone = user.getTelefone();
		senha = user.getSenha();
		
	
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public List<PedidoDTO> getPedido() {
		return pedido;
	}


	public void setPedido(List<PedidoDTO> pedido) {
		this.pedido = pedido;
	}
	
	
	
}
