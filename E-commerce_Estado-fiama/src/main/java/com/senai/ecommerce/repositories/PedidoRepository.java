package com.senai.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.ecommerce.entities.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
