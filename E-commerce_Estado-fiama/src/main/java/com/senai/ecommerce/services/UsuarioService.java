package com.senai.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.ecommerce.dto.ProdutoDTO;
import com.senai.ecommerce.dto.UsuarioDTO;
import com.senai.ecommerce.entities.Usuario;
import com.senai.ecommerce.repositories.PedidoRepository;
import com.senai.ecommerce.repositories.UsuarioRepository;

@Service
public class UsuarioService {
   
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private PedidoRepository pedrepo;
	
	public List<UsuarioDTO> buscarPedidosPorrUsuario(){
		List<Usuario> list = usuarioRepo.findAll();
		return list.stream().map(UsuarioDTO::new).toList(); 
		
	}
}
