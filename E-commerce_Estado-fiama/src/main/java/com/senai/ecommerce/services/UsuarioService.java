package com.senai.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<UsuarioDTO> buscarPedidosPorrUsuario(){
		List<Usuario> list = usuarioRepo.findAll();
		return list.stream().map(UsuarioDTO::new).toList(); 
		
	}
	
	public UsuarioDTO salvarUsuario(UsuarioDTO dto) {
		Usuario user = new Usuario();
		user.setEmail(dto.getEmail());
		user.setSenha(passwordEncoder.encode(dto.getSenha()));
		user = usuarioRepo.save(user);
		return new UsuarioDTO(user);
	}
   
	public boolean autenticarUsuario(UsuarioDTO dto) {
		Usuario user = usuarioRepo.findByEmail(dto.getEmail());

		if (user == null) {
			return false;
		}

		
		return passwordEncoder.matches(dto.getSenha(), user.getSenha());
	}
}
