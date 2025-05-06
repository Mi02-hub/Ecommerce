package com.senai.ecommerce.dto;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.entities.StatusDoPedido;

public class PedidoDTO {

	private Long id;
	private Instant momento;
	private String nomeProduto;
	private StatusDoPedido status;
	private Long clienteId;
	private Set<ItemDoPedidoDTO> itens;

	public PedidoDTO() {

	}

	public PedidoDTO(Long id, Instant momento, String nomeProduto, StatusDoPedido status, Long clienteId) {
		this.id = id;
		this.momento = momento;
		this.nomeProduto = nomeProduto;
		this.status = status;
		this.clienteId = clienteId;

	}

	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getId(); 
		this.nomeProduto = pedido.getNomeProduto();
		this.momento = pedido.getMomento();
		this.status = pedido.getStatus();
		this.clienteId = pedido.getCliente().getId();
		this.itens = pedido.getItems().stream().map(ItemDoPedidoDTO::new).collect(Collectors.toSet());
	}

	public Set<ItemDoPedidoDTO> getItens() {
		return itens;
	}

	public void setItens(Set<ItemDoPedidoDTO> itens) {
		this.itens = itens;
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

	public StatusDoPedido getStatus() {
		return status;
	}

	public void setStatus(StatusDoPedido status) {
		this.status = status;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

}
