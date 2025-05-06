package com.senai.ecommerce.dto;

import com.senai.ecommerce.entities.ItemDoPedido;

public class ItemDoPedidoDTO {

    private Long pedidoId;
    private Long produtoId;
    private String nomeProduto;
    private Integer quantidade;
    private Double preco;

    public ItemDoPedidoDTO() {
    }

    public ItemDoPedidoDTO(ItemDoPedido item) {
        this.pedidoId = item.getPedido().getId(); 
        this.produtoId = item.getProduto().getId(); 
        this.nomeProduto = item.getProduto().getNome(); 
        this.quantidade = item.getQuantidade();
        this.preco = item.getPreco();
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
