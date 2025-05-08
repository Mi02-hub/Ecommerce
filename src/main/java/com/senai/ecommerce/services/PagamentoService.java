package com.senai.ecommerce.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.ecommerce.entities.Pagamento;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.entities.StatusDoPedido;
import com.senai.ecommerce.repositories.PagamentoRepository;
import com.senai.ecommerce.repositories.PedidoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class PagamentoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Transactional
	public void efetuarPagamento(Long pedidoId) {
		Pedido pedido = pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));

		if (!pedido.getStatus().equals(StatusDoPedido.AGUARDANDO_PAGAMENTO)) {
			throw new RuntimeException("Pagamento já foi efetuado.");
		}

		Pagamento pagamento = new Pagamento();
		pagamento.setMomento(Instant.now());
		pagamento.setPedido(pedido);
		pagamentoRepository.save(pagamento);

		pedido.setStatus(StatusDoPedido.PAGO);
		pedidoRepository.save(pedido);
	}

}
