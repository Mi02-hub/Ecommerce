package com.senai.ecommerce.entities;

import java.time.Instant;

import java.util.HashSet;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant momento;
	private String nomeProduto;

	@Enumerated(EnumType.STRING)
	private StatusDoPedido status;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;

	@OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
	private Pagamento pagamento;

	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemDoPedido> items = new HashSet<>();

	public Pedido() {

	}

	public Pedido(Long id, Instant momento, String nomeProduto, StatusDoPedido status, Usuario cliente,
			Pagamento pagamento, Set<ItemDoPedido> items) {
		this.id = id;
		this.momento = momento;
		this.nomeProduto = nomeProduto;
		this.status = status;
		this.cliente = cliente;
		this.pagamento = pagamento;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public StatusDoPedido getStatus() {
		return status;
	}

	public void setStatus(StatusDoPedido status) {
	    this.status = status;
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<ItemDoPedido> getItems() {
		return items;
	}

	public void setItems(Set<ItemDoPedido> items) {
		this.items = items;
	}

}
