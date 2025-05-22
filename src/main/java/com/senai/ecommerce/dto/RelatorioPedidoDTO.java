package com.senai.ecommerce.dto;

import java.time.format.DateTimeFormatter;

import com.senai.ecommerce.entities.Pedido;

public class RelatorioPedidoDTO {

    private Long cliente;
    private Long pedido;
    private String status;
    private String momento;


    // Construtor vazio
    public RelatorioPedidoDTO() {
        this.cliente = 0L;
        this.pedido = 0L;
        this.status = "N/A";
        this.momento = "N/A";
    }

    // Construtor
    public RelatorioPedidoDTO(Pedido entity) {
        // Tratamento defensivo para todos os campos
        this.cliente = (entity.getCliente() != null) ? entity.getCliente().getId() : 0L;
        this.pedido = entity.getId();
        this.status = (entity.getStatus() != null) ? entity.getStatus().toString() : "Status não definido";
        
        // Tratamento para o campo momento
        if (entity.getMomento() != null) {
            this.momento = entity.getMomento().atZone(java.time.ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        } else {
            this.momento = "Data não informada";
        }
    }

    // Apenas os Getters 
    public Long getCliente() {
        return cliente;
    }
    public Long getPedido() {
        return pedido;
    }
    public String getStatus() {
        return status;
    }
    public String getMomento() {
        return momento;
    }
    
    // Adicionar setters para criar instâncias manualmente
    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }
    
    public void setPedido(Long pedido) {
        this.pedido = pedido;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setMomento(String momento) {
        this.momento = momento;
    }
}