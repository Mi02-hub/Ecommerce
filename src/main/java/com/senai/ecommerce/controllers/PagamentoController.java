package com.senai.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.ecommerce.services.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	@Autowired
	private PagamentoService pagamentoService;

	@PostMapping("/{pedidoId}")
    public ResponseEntity<String> efetuarPagamento(@PathVariable Long pedidoId) {
        pagamentoService.efetuarPagamento(pedidoId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pagamento efetuado com sucesso! :) ");
    }
}
