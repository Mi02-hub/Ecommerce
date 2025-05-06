package com.senai.ecommerce.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.ecommerce.dto.ItemDoPedidoDTO;
import com.senai.ecommerce.dto.PedidoDTO;
import com.senai.ecommerce.entities.ItemDoPedido;
import com.senai.ecommerce.entities.Pedido;
import com.senai.ecommerce.entities.Produto;
import com.senai.ecommerce.entities.StatusDoPedido;
import com.senai.ecommerce.repositories.ItemDoPedidoRepository;
import com.senai.ecommerce.repositories.PedidoRepository;
import com.senai.ecommerce.repositories.ProdutoRepository;
import com.senai.ecommerce.repositories.UsuarioRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ItemDoPedidoRepository itemDoPedidoRepository;


	public PedidoDTO inserir(PedidoDTO dto) {
	    Pedido pedido = new Pedido();
	    pedido.setMomento(Instant.now());
	    pedido.setStatus(StatusDoPedido.AGUARDANDO_PAGAMENTO);
	    pedido.setCliente(usuarioRepository.getReferenceById(dto.getClienteId()));

	    pedido = pedidoRepository.save(pedido);

	    for (ItemDoPedidoDTO itemDTO : dto.getItens()) {
	        Produto produto = produtoRepository.getReferenceById(itemDTO.getProdutoId());
	        ItemDoPedido item = new ItemDoPedido(pedido, produto, itemDTO.getQuantidade(), itemDTO.getPreco());
	        itemDoPedidoRepository.save(item);
	    }

	    PedidoDTO pedidoDTO = new PedidoDTO(pedido);
	    pedidoDTO.setItens(dto.getItens());

	    return pedidoDTO;
	}

}
