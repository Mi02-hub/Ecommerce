package com.senai.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.ecommerce.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
